|                             _cat                             |            描述            |
| :----------------------------------------------------------: | :------------------------: |
|             http://codekenan.icu:9200/_cat/nodes             |        查看所有节点        |
|            http://codekenan.icu:9200/_cat/health             |        查看健康状况        |
|            http://codekenan.icu:9200/_cat/master             |       查看主节点信息       |
|            http://codekenan.icu:9200/_cat/indices            |        查看所有索引        |
|                                                              |                            |
|                         索引一个文档                         |                            |
| PUT  http://codekenan.icu:9200/customer/external/1 {"name":"zhangsan"} |         保存/更新          |
| POST  http://codekenan.icu:9200/customer/external/1 {"name":"lisi"} |         保存/更新          |
|      GET  http://codekenan.icu:9200/customer/external/1      |            查询            |
| PUT http://codekenan.icu:9200/customer/external/1?if_seq_no=7&if_primary_term=1 |        并发修改 CAS        |
| POST http://codekenan.icu:9200/customer/external/1/_update  {"doc":{"name":"zhangsan"}} | 更新,对比源数据，一样 noop |
| POST http://codekenan.icu:9200/customer/external/1/_update  {"doc":{"name":"zhangsan","age":12}} |          增加属性          |
|                                                              |                            |
|    DELETE  http://codekenan.icu:9200/customer/external/1     |            删除            |
|          DELETE http://codekenan.icu:9200/customer           |          删除索引          |
|                                                              |                            |
| POST  http://codekenan.icu:9200/customer/external/_bulk   {action:{},} {request body} |          批量操作          |

```java
{"index":{"_id":"1"}}
{"name": "John Doe"}
{"index":{"_id":"2"}}
{"name": "Paul Doe"}
```

```java
POST _bulk
{"delete":{"_index":"website","_type":"blog","_id":"123"}}//删除文档
{"create":{"_index":"website","_type":"blog","_id":"123"}}//新建文档
{"title":"My first blog post"}
{"index":{"_index":"website","_type":"blog"}}//创建/更新文档
{"title":"My second blog post"}
{"update":{"_index":"website","_type":"blog","_id":"123","_retry_on_conflict":3}}//更新文档
{"doc":{"title":"My updated blog post"}}
```



GET  http://codekenan.icu:9200/customer/external/_search?q=*&sort=account_number:asc

GET  http://codekenan.icu:9200/customer/external/_search

### Query DSL

```json
{
    "query":
    {
        "match_all":{}
    },
    "sort":
    [
        {"account_number":"asc"},
        {"balance":"desc"}
    ],
    "from":10,
    "size":10,
    "_source":["balance"]
}
```



```json
{
    "query":
    {
        "match":{"account_number":20}
    }
}
```

模糊检索 分词匹配

```json
{
    "query":
    {
        "match":{"address":"Mill"}
    }
}
```

短语匹配  | address.keyword  精确 全部值

```json
{
    "query":
    {
        "match_phrase":{"address":"Mill lane"}
    }
}
```

多字段匹配 分词

```json
{
    "query":
    {
        "multi_match":{
            "query":"mill",
            "fields":["address","city"]
        }
    }
}
```

复合查询

```json
{
    "query":
    {
        "bool":{
            "must":[
                {"match":{
                    "gender":"M"
                }},
                {"match":{
                    "address":"mill"
                }}
            ],
            "must_not":[
                {"match":{
                    "age":18
                }}
            ],
            "should":[
                {"match":{
                    "lastname":"Wallace"
                }}
            ]
        }
    }
}
```

结果过滤  

```json
{
    "query":{
        "bool":{
            "must":[
                {"range":{
                    "age":{
                        "gte":18,
                        "lte":30
                    }
                }},
                {"match":{
                    "address":"mill"
                }}
            ]
        }
    }
}
```

filter  不贡献得分

```json
{
    "query":{
        "bool":{
            "filter":{
                "range":{
                    "age":{
                        "gte":18,
                        "lte":30
                    }
                }
            }
        }
    }
}
```

非文本字段  精确字段  term    全文检索 match

```json
{
    "query":{
        "term":{
            "age":28
        }
    }
}
```

### 聚合

```json
{
    "query":{
        "match":{
			"address":"mill"
        }
    },
    "aggs":{
        "ageAgg":{
            "terms":{
				"field":"age",
                "size":10
            }
        },
        "ageAvg":{
            "avg":{
                "field":"age"
            }
        },
        "balanceAvg":{
            "avg":{
                "field":"balance"
            }
        }
    },
     "size":0
}
```



```json	
{
    "query":{
        "match_all":{}
    },
    "aggs":{
        "ageAgg":{
            "terms":{
                "field":"age",
                "size":100
            },
            "aggs":{
                "balanceAvg":{
                    "avg":{
                        "field":"balance"
                    }
                }
            }
        }
    }
}
```

```json
{
    "query":{
        "match_all":{}
    },
    "aggs":{
        "ageAgg":{
            "terms":{
                "field":"age",
                "size":100
            },
            "aggs":{
                "genderAgg":{
                    "terms":{
                        "field":"gender.keyword"
                    },
                    "aggs":{
                        "balanceAvg":{
                            "avg":{
                                 "field":"balance"
                            }
                        }
                    }
                },
                "balanceAvg":{
                    "avg":{
                        "field":"balance"
                    }
                }
            }
        }
    }
}
```

### 映射

PUT  /my_index

```json	
{
    "mappings":{
        "properties":{
            "age":{"type":"integer"},
            "email":{"type":"keyword"},
            "name":{"type":"text"}
        }
    }
}
```

PUT /my_index/_mapping

```json
{   
    "properties":{
        "employee-id":{
            "type":"keyword",
            "index":false
        }
    }    
}
```



PUT /bank

```json
{
    "mappings":{
        "properties": {
            "account_number": {
                "type": "long"
            },
            "address": {
                "type": "text"
            },
            "age": {
                "type": "integer"
            },
            "balance": {
                "type": "long"
            },
            "city": {
                "type": "keyword"
            },
            "email": {
                "type": "keyword"
            },
            "employer": {
                "type": "keyword"
            },
            "firstname": {
                "type": "text"
            },
            "gender": {
                "type": "keyword"
            },
            "lastname": {
                "type": "text",
                "fields": {
                    "keyword": {
                        "type": "keyword",
                        "ignore_above": 256
                    }
                }
            },
            "name": {
                "type": "text",
                "fields": {
                    "keyword": {
                        "type": "keyword",
                        "ignore_above": 256
                    }
                }
            },
            "state": {
                "type": "keyword",
                "fields": {
                    "keyword": {
                        "type": "keyword",
                        "ignore_above": 256
                    }
                }
            }
        }
    }
}
```

数据迁移

```json
{
    "source":{
        "index":"customer",
        "type":"external"
    },
    "dest":{
        "index":"bank"
    }
}
```

分词

GET   http://codekenan.icu:9200/bank/_analyze

```json
{
    "analyzer":"ik_smart",
    "text":"乔碧萝殿下"
}
```

