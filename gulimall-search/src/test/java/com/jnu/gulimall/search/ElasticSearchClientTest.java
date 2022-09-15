package com.jnu.gulimall.search;

import com.alibaba.fastjson.JSON;
import com.jnu.gulimall.search.config.GulimallElasticSearchConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * [一句话描述该类的功能]
 *
 * @author : [游成鹤]
 * @version : [v1.0]
 * @createTime : [2022/8/24 13:16]
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchClientTest {

    @Autowired
    private RestHighLevelClient client;

    @Test
    public void test() {
        System.out.println(client);
    }

    @Test
    public void index() throws IOException {
        IndexRequest request = new IndexRequest("users");
        request.id("1");
//        request.source("userName","zhangsan","age",18,"gender","男");
        User user = new User("zhangsan", 18, "男");
        request.source(JSON.toJSONString(user), XContentType.JSON);
        IndexResponse index = client.index(request, GulimallElasticSearchConfig.COMMON_OPTIONS);
        System.out.println(index);
    }

    @Test
    public void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("bank");

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchQuery("address","mill"));

        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(10);

        AvgAggregationBuilder balanceAvg = AggregationBuilders.avg("balanceAvg").field("balance");

        builder.aggregation(ageAgg);
        builder.aggregation(balanceAvg);

        System.out.println(builder.toString());
        System.out.println("-----------------------------------------------------------------------------------");
        searchRequest.source(builder);
        SearchResponse search = client.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

        System.out.println(search);
        System.out.println("-----------------------------------------------------------------------------------");
        SearchHit[] hits = search.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsMap());
            System.out.println("-----------------------------------------------------------------------------------");
        }

        Aggregations aggregations = search.getAggregations();

        Terms ageAgg1 = aggregations.get("ageAgg");
        for (Terms.Bucket bucket : ageAgg1.getBuckets()) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println(keyAsString);
            System.out.println(bucket.getDocCount());
            System.out.println("-----------------------------------------------------------------------------------");
        }

        Avg balanceAvg1 = aggregations.get("balanceAvg");

        System.out.println(balanceAvg1.getValue());

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private String userName;
        private int age;
        private String gender;
    }

}