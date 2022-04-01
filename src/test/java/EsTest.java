//import org.springframework.util.StringUtils;
//
//import java.net.InetAddress;
//
///**
// * @author: xianhui.yu
// * @create: 2021-08-13 14:57
// **/
//public class EsTest {
//
//    public static void main(String[] args) {
//        //创建client
//        TransportClient transportClient = getTransportClient(address);
//        transportClient.addTransportAddress(new
//                InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
//    }
//    private static TransportClient getTransportClient(Service.Address address) {
//        Settings.Builder elasticsearch = Settings.builder()
//                .put("cluster.name", "kydev")
////                .put("client.transport.ignore_cluster_name", true)
//                .put("client.transport.sniff", false)
//                .put("client.node", false)
//                .put("transport.type", "netty3");
//        if (!StringUtils.hasLength(address.getUsername())) {
//            return new PreBuiltTransportClient(elasticsearch.build());
//        }
//        String password = address.getDecodedPassword();
//        elasticsearch.put("transport.type", "security3");
//        elasticsearch.put("xpack.security.user", address.getUsername() + ":" + password);
//        return new PreBuiltXPackTransportClient(elasticsearch.build());
//    }
//}
