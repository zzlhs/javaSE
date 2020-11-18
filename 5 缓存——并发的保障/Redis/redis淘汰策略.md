### 配置Redis作为缓存（六种淘汰策略）
将Redis用做缓存时，如果内存空间用满，就会自动驱逐老的数据。  

LRU是Redis唯一支持的回收算法，本文详细介绍用于限制最大内存使用量的
#### maxmemory指令
深入讲解Redis所使用的近似LRU算法。  
maxmemory配置指令  
maxmemory用于Redis能使用的最大内存。既可以在redis.conf文件中设置，  
也可以再运行过程中通过config set命令动态修改。  
例如，要设置100MB的内存限制，可以在redis.conf文件中这样配置：  
maxmemory 100mb  
将maxmemory设置为0，则表示不进行内存限制，当然，对32位系统来说有一个隐性的限制条件：最多3GB内存。  
当内存使用达到最大限制时，如果需要存储新数据，根据配置的策略（policies）的不同，Redis可能直接返回错误信息，  
或者删除部分老的数据。  

#### 驱逐策略
达到最大内存限制时（maxmemory），Redis根据maxmemory-policy配置的策略，来决定具体的行为。
当前版本，Redis3.0支持的策略包括：
##### 1 noeviction
不删除策略，达到最大内存限制时，如果需要更多内存，直接返回错误信息。  
大多数写命令都会导致占用更多的内存（有极少数例外，如del）  

##### 2 allkeys-lru
所有key通用，优先删除最近最少使用的(less recently used,LRU)key.  

##### 3 allkeys-random
所有key通用，随机删除一部分key.

##### 4 volatile-random
只限于设置了expire的部分，删除一部分expire的key.

##### 5 volatile-ttl
只限于设置了expire的部分，优先删除剩余时间(time to live,TTL)短的key.

##### other
如果没有设置expire的key,不满足先决条件（prerequisites）,那么volatile-lru,volatile-random和volatile-ttl策略的行为，
和noeviction（不删除策略）基本上一致。

一般来说：
如果分为热数据和冷数据，推荐使用allkeys-lru策略，也就是，其中一部分key经常被读写，如果不确定具体的业务特征，  
那么allkeys-lru是一个很好的选择。  

如果需要循环读写所有的key,或者各个key的访问频率差不多，可以使用allkeys-random策略，即读写所有的元素的概率差不多。  

假如要让Redis根据ttl来筛选需要删除的key,请使用volatile-ttl策略。  

volatile-lru和volatile-random策略主要应用场景是：既有缓存，又有持久key的实例中，一般来说，像这类场景，应该使用两个单独的Redis实例。  
值得一提的是，设置expire会消耗额外的内存，所以使用allkeys-lru策略，可以更高效的利用内存，因为这样就可以不再设置过期时间了。  

#### 驱逐的内部实现

驱逐过程可以这样理解：  
1、客户端执行一个命令，导致Redis中的数据增加，占用更多的内存。
2、Redis检查内存使用量，如果超出maxmemory限制，根据策略清除部分key.  
3、继续执行下一条命令，以此类推。  
在这个过程中，内存使用量会不断的达到limit值，然后超过，然后删除部分key,使用量又下降到limit值之下。  
如果某个命令导致大量内存使用（比如通过新key保存一个很大的set）,在一段时间内，可能内存的使用量会明显超过maxmemory限制。  
近似LRU算法
Redis使用的并不是完全LRU算法，自动驱逐的key,并不一定是最满足LRU特征的那个，而是通过近似LRU算法，  
抽取少量的key样本，然后删除其中访问时间最古老的那个key.  
驱逐算法，从Redis3.0开始得到了巨大的优化，使用pool(池子)来作为候选，  
这大大提升了算法的效率，也更接近真实的LRU算法。  

测试过程中, 依次从第一个 key 开始访问, 所以最前面的 key 才是最佳的驱逐对象。

从图中可以看到三种类型的点, 构成了三个不同的条带。

浅灰色部分表示被驱逐的对象。
灰色部分表示 “未被驱逐” 的对象。
绿色部分表示后面加入的对象。
在纯粹的LRU算法实现中, 前半部分旧的key被释放了。而 Redis 的 LRU 算法只是将时间较长的 key 较大概率地(probabilistically)释放了。

如你所见, Redis 3.0 中, 5样本的效果比 Redis 2.8 要好很多。 当然, Redis 2.8 也不错,最后访问的key基本上都还留在内存中. 在 Redis 3.0 中使用 10 样本时, 已经非常接近纯粹的LRU算法了。

注意,LRU只是用来预测将来可能会继续访问某个key的一个概率模型. 此外,如果数据访问的情况符合幂律分布(power law), 那么对于大部分的请求来说, LRU都会表现良好。

在模拟中, 我们发现, 如果使用幂律方式访问, 纯粹的LRU和Redis的结果差别非常, 甚至看不出来。

当然也可以将样本数量提高到10, 以额外消耗一些CPU为代价, 使得结果更接近于真实的LRU, 并通过 cache miss 统计信息来判断差异。

设置样本大小很容易, 使用命令 CONFIG SET maxmemory-samples <count> 即可。


https://blog.csdn.net/ligupeng7929/article/details/79603060