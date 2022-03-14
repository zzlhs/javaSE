#### 1 启动镜像
```aspectj
    docker run --name mysql.5.7.21 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Nzy19970502 -d mysql:5.7.21
```
-e : 为设置执行时的环境变量，在这里我设置mysql的root密码  


#### 2 将容器中MySQL的3306端口映射到本地的3306端口，并设置登录密码为：123456
```
docker run --name mysql5.7 
           -p 3306:3306 
           -v /docker/mysql/data:/var/lib/mysql 
           -v /docker/mysql/conf:/etc/mysql/conf.d 
           -e MYSQL_ROOT_PASSWORD=123456 
           -d mysql:5.7
```
##### 进入容器
```aspectj
docker exec -it mysqlNo /bin/bash
```

#### 3 如果启动多个容器需要删除某个 可以执行docker ps -l 查询当前运行的容器 docker rm 容器id 删除对应的容器实例


