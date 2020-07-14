## RabbitMQ 介绍

### 1 基本结构
![Image text](https://github.com/zhengyuanfeng521/javaSE/blob/master/%E6%B6%88%E6%81%AF%E9%98%9F%E5%88%97/RabbitMQ/images/rabbitMQ%E5%9F%BA%E6%9C%AC%E7%BB%93%E6%9E%84.png)


Broker 消息队列服务进程，包括Exchange和Queue  
Exchange 消息队列交换机，按一定的规则将消息路由转发到某个队列，对消息进行过滤  
Queue 消息队列，存储消息，使消息到达队列并发转发给指定的消费方  
Producer 生产方客户端将消息发送到MQ  
Consumer 接收MQ转发的消息  

### 2 工作模式（5种）

1 Work queues  
2 Publish/Subscribe    
3 Routing  
4 Topics  
5 Header  
6 RPC  

#### 第一种 work queues模式

这种模式一个队列可以对应多个consumer，rabbitMQ这里会以轮询的方式平均将消息发送给consumer

#### 第二种 发布/订阅

每个消费者监听自己的队列  
生产者将消息发给broker，由交换机将消息转发到绑定此交换机的每个队列，每个绑定交换机的队列都将接受到消息  

#### 第三种 路由模式

每个消费者监听自己的队列，并且设置routingKey  
生产者将消息发给broker，由交换机根据routingKey将消息发送到绑定的哪个队列去  

#### 第四种 topics

每个消费者监听自己的队列，并且设置带有通配符的routingKey  
生产者将消息发给broker，由交换机根据routingKey将消息发送到绑定的哪个队列去  

#### 第五种 Header模式


header模式与routing不同的地方在于，header模式取消routingkey，使用header中的 key/value（键值对）匹配 队列  

#### 第六种 RPC模式

就是充分的使用RabbitMQ，上面的会了，这个很容易的  

### 相关英文及解释
fanout	
n.	输出（端数）；展（散）开；扇出; 分列账户;

direct
adj.	直接的; 亲自的; 亲身的; 笔直的; 径直的; 最近的; 直射的;
v.	把…对准(某方向或某人); 管理; 监督; 指导; 导演(戏剧或电影); 指挥(管弦乐队);
adv.	直接; 径直; 亲自;


topic
n.	话题; 题目; 标题;


