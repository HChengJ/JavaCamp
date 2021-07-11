package Week3.Work;


import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpClient {
    // 缓存客户端实例
    public static okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

    // GET 调用
    public static String getString(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url).get()
                .build();
        Call call = client.newCall(request);
        try{
            Response response = call.execute();
            return response.body().string();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return  null;
    }


    public static void main(String[] args) throws Exception {
        String url = "http://localhost:9000/test";
        String text = OkHttpClient.getString(url);
        System.out.println("url: " + url + " ; response: \n" + text);
        // 清理资源
        OkHttpClient.client = null;
    }
}
