package elasticsearch;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author yuxianhui
 * @create 2019-12-17 18:57
 **/
public class InitDemo {
    public static RestHighLevelClient getClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9201, "http")));


        return client;
    }
}
