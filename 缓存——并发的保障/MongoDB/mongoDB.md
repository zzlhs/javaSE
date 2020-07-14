## mongoDB

### 1 常用
	mongo.conf 是配置文件
	用studio3t做为可视化软件
	
### 2 基础概念
	database
	collection
	document
	field
	index
	primary key (MongoDB自动再每个集合中添加_id的主键)

mongod --dbpath D:/developer/MongoDB/Server/3.4/data

### 3 springBoot连接mongoDB

#### 3.1 配置文件写法

	mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][? options]] 
	
![Image text](https://github.com/zhengyuanfeng521/javaSE/blob/master/%E7%BC%93%E5%AD%98%E2%80%94%E2%80%94%E5%B9%B6%E5%8F%91%E7%9A%84%E4%BF%9D%E9%9A%9C/MongoDB/images/mongoDB%26springBoot.png)
#### 3.2 与springBoot连用

maven坐标
```
		<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-mongodb</artifactId>
        </dependency>
```

相关注解
@Document(collection = "document_name") 
@Id
@Field("d_name")

dao层代码编写
	一般用到的方法MongoRepository都为我们实现好了，和JPA的调用方式大体相似，下面一些我们常用的方法也可以自己去实现
```
		public interface CmsPageRepository extends MongoRepository<CmsPage, String>{
			
			CmsPage findByPageName(String pageName);
			
			CmsPage findByPageNameAndPageType(String pageName, String pageType);
			
			CmsPage findBySiteIdAndPageType(String siteId, String pageType);
			
			int countBySiteIdAndPageType(String siteId, String pageType);
			
			Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);
			
			CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName, String siteId, String pageWebPath);

		}
```

### 4 GridFS介绍

	在GridFS存储文件是将文件分块存储，文件会按照256KB的大小分割成多个块进行存储，GridFS使用两个集合 （collection）
存储文件，一个集合是chunks, 用于存储文件的二进制数据；一个集合是ﬁles，用于存储文件的元数 据信息（文件名称、块大
小、上传时间等信息）

http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f


	
	