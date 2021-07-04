package Week2.Work;



import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class OkHttpUtils {
    // 缓存客户端实例
    public static OkHttpClient client = new OkHttpClient();

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
        String url = "http://localhost:8801/";
        String text = OkHttpUtils.getString(url);
        System.out.println("url: " + url + " ; response: \n" + text);
        // 清理资源
        OkHttpUtils.client = null;
    }
}
