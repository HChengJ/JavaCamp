package Week3.Work;

import Week3.NIO_Gateway.router.HttpEndpointRouter;

import java.util.List;
import java.util.Random;

public class RandomNettyRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
