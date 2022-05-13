package com.techprimers.elastic.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.techprimers.elastic.jparepository")
@EnableElasticsearchRepositories(basePackages = "com.techprimers.elastic.repository")
public class ElasticConfiguration extends AbstractElasticsearchConfiguration{

    @Value("${elasticsearch.url}")
    public String elasticsearchUrl;

//    @Bean
//    public NodeBuilder nodeBuilder() {
//        return new NodeBuilder();
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws IOException {
//        File tmpDir = File.createTempFile("elastic", Long.toString(System.nanoTime()));
//        System.out.println("Temp directory: " + tmpDir.getAbsolutePath());
//        Settings.Builder elasticsearchSettings =
//                Settings.settingsBuilder()
//                        .put("http.enabled", "true") // 1
//                        .put("index.number_of_shards", "1")
//                        .put("path.data", new File(tmpDir, "data").getAbsolutePath()) // 2
//                        .put("path.logs", new File(tmpDir, "logs").getAbsolutePath()) // 2
//                        .put("path.work", new File(tmpDir, "work").getAbsolutePath()) // 2
//                        .put("path.home", tmpDir); // 3
//
//
//        return new ElasticsearchTemplate(nodeBuilder()
//                .local(true)
//                .settings(elasticsearchSettings.build())
//                .node()
//                .client());
//    }

    @Bean
    @Override
    public RestHighLevelClient elasticsearchClient() {
        RestClientBuilder restClientBuilder;
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );
//        final ClientConfiguration config = ClientConfiguration.builder()
//                .connectedTo(elasticsearchUrl)
////                .withSocketTimeout(100000000)
//                .build();
//        return RestClients.create(config).rest();

        return client;
    }

}
