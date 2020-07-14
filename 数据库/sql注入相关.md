### mybatis中易产生的sql注入漏洞

#### 情况1 

'%#{title}%'  
这种情况下不行，可能会把#变成$,这样如果java层面没有做处理会出现问题  

正确写法  
concat('%', #{title}, '%')  

#### 情况2

in (#{ids})  

正确写法  
id in <foreach collection='ids' item='item' open="(" separatosr="," close=")">#{ids}</foreach>  

#### 情况3

order by之后











