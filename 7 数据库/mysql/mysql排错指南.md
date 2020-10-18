## 1 优化终点

1.1 直接的select  
```
select * from table_name
```

1.2 on / where / group by 的使用  

使用explain
非唯一的行永远不会产生eq_ref或者更好的类型

1.3 比较表中只有一行记录和表中超过50%的行都有相同记录，在后者中，使用index或降低性能

频繁插入的表带有索引会降低性能





