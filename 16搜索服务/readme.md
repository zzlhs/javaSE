##2.5 es

https://blog.csdn.net/u011863024/article/details/115721328
###2.5.1 结构

关系型数据库 | database | table | row | column

es|
####1

| 关系 | 表头 | 表头 | 表头 | 表头 | 
|---|---|---|---|---|  
|关系型数据库 | database | table | row | column |
|es|Index|Type（已废除）| Document | Field |

###2.5.2 查询方式

**[目录]**  
<a href="#p1"><font size=2 color=#00f>1、主键查询｜全查询</font></a>  
<a href="#p2"><font size=2 color=#00f>2、全量修改｜局部修改｜删除</font></a>  
<a href="#p3"><font size=2 color=#00f>3、条件查询｜分页查询｜查询排序</font></a>  
<a href="#p4"><font size=2 color=#00f>4、多条件查询｜范围查询</font></a>  
<a href="#p5"><font size=2 color=#00f>5、全文检索｜完全匹配｜高亮查询</font></a>  
<a href="#p6"><font size=2 color=#00f>6、聚合查询｜</font></a>




 
#### <a id="p1">1、主键查询｜全查询</a>
#### <a id="p2">2、全量修改｜局部修改｜删除</a>
#### <a id="p3">3、条件查询｜分页查询｜查询排序</a>

match_all
```aspectj
{
	"query":{
		"match_all":{}
	}
}
```
查询指定属性
```aspectj
{
	"query":{
		"match_all":{}
	},
	"_source":["title"] // 只显示title属性
}

```
分页查询
```aspectj
{
	"query":{
		"match_all":{}
	},
	"from":0,
	"size":2
}

```
查询排序
```aspectj
{
	"query":{
		"match_all":{}
	},
	"sort":{
		"price":{ // 排序属性
			"order":"desc" // 排序方式 desc ｜ asc
		}
	}
}

```
#### <a id="p4">4、多条件查询｜范围查询</a>

bool must
```aspectj
{
	"query":{
		"bool":{
			"must":[{
				"match":{
					"category":"小米"
				}
			},{
				"match":{
					"price":3999.00
				}
			}]
		}
	}
}

```
bool should  
filter
```aspectj
{
	"query":{
		"bool":{
			"should":[{
				"match":{
					"category":"小米"
				}
			},{
				"match":{
					"category":"华为"
				}
			}]
		},
        "filter":{
            "range":{
                "price":{
                    "gt":2000
                }
            }
        }
	}
}

```
#### <a id="p5">5、全文检索｜完全匹配｜高亮查询</a>

全文检索  返回结果带回品牌有“小”和华的。
```aspectj
{
	"query":{
		"match":{
			"category" : "小华"
		}
	}
}
```
完全匹配
```aspectj
{
	"query":{
		"match_phrase":{
			"category" : "为"
		}
	}
}
```
高亮查询
```aspectj
{
	"query":{
		"match_phrase":{
			"category" : "为"
		}
	},
    "highlight":{
        "fields":{
            "category":{}//<----高亮这字段
        }
    }
}
```
#### <a id="p6">6、聚合查询</a>
聚合允许使用者对 es 文档进行统计分析，类似与关系型数据库中的 group by，当然还有很多其他的聚合，例如取最大值max、平均值avg等等。  
带有原始数据
```aspectj
{
	"aggs":{//聚合操作
		"price_group":{//名称，随意起名
			"terms":{//分组
				"field":"price"//分组字段
			}
		}
	}
}
```
不带有原始数据
```aspectj
{
	"aggs":{
		"price_group":{
			"terms":{
				"field":"price"
			}
		}
	},
    "size":0 // 带不带原始数据关键
}
```
avg
```aspectj
{
	"aggs":{
		"price_avg":{//名称，随意起名
			"avg":{//求平均
				"field":"price"
			}
		}
	},
    "size":0
}

```
