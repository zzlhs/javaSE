## 介绍

突出优点  
1 扩展性好，可部署上百台服务器集群，处理pb级数据  
2 近实时的去索引数据，搜索数据
 


## 索引结构

分词   
document  

倒排索引  

## IK分词器

要注意，在使用ik分词器时es的安装路径不能含有中文

| 链接地址| 请求方式 |作用|
| ------- | -------- | ---|
|localhost:9200/_analyze| post | 分词器的使用的测试 |
|localhost:9200/_mapping| get | 查询es中所有的mapping |
|localhost:9200/xc_course/doc/_mapping|post|创建或更新index，切记已经建立的index只能加字段，已有字段不能更新|


搜索时 粗粒度分词器  
索引时 细粒度分词器  

## 常用映射类型



## 各个类型的用法

text

```
{
   "properties": {
       "name": {
           "type": "text",
           "analyzer": "ik_max_word",
           "search_analyzer": "ik_smart",
           "index": true,
           "store": false
       },
       "description": {
           "type": "text",
           "analyzer": "ik_max_word",
           "search_analyzer": "ik_smart"
       },
       "pic": {
           "type": "text",
           "index": false
       },
       "studymodel": {
           "type": "keyword"
       }
   }
}
	
```

keyword的默认index为全匹配
时间  格式的使用  
数值 比例因子的使用   

## 关于es中java代码的crud可以去代码中查查看一下啊

## 搜索


## 

通过下边两项参数来配置结点的功能：  
node.master: #是否允许为主结点 node.data: #允许存储数据作为数据结点 node.ingest: #是否允许成为协调节点，  
四种组合方式：  
master=true，data=true：即是主结点又是数据结点  
master=false，data=true：仅是数据结点 master=true，data=false：仅是主结点，不存储数据 master=false，data=false：即不是主结点也不是数据结点，此时可设置ingest为true表示它是一个客户端  
