package test.order.common.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */

@Configuration
public class RestTemplateConfig {

    @Value("${sender.timeout:15000}")
    int timeout;

    @Value("${http.connection-manager.max-total}")
    public int maxTotalConnectionsSize;

    @Value("${http.connection-manager.max-per-host}")
    public int maxPerHost;

    @Bean
    public RestTemplate restTemplate() {

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotalConnectionsSize);
        connectionManager.setDefaultMaxPerRoute(maxPerHost);

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
        factory.setConnectTimeout(timeout);
        factory.setReadTimeout(timeout);
        factory.setConnectionRequestTimeout(timeout); //connection manager
        return new RestTemplate(factory);
    }

}