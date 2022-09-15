```bash
docker run --name elasticsearch -p 9200:9200 -p 9300:9300 \
-e  "discovery.type=single-node" \
-e ES_JAVA_OPTS="-Xms64m -Xmx128m" \
-v /root/docker/elastic/config/elasticsearch.yml:/usr/share/elasticsearch/config/elasticsearch.yml \
-v /root/docker/elastic/data:/usr/share/elasticsearch/data \
-v  /root/docker/elastic/plugins:/usr/share/elasticsearch/plugins \
-d elasticsearch:7.4.2
```

