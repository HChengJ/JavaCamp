package Week1.CalssLoader;

import Week1.Hello.Hello;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoadAddURL {
    public static void main(String[] args) {
//        String appPath = "file:/F:/IdeaWorkSpace/JavaCamp/out/production/JavaCamp/Week1/";
        String appPath = "file:/F:/IdeaWorkSpace/JavaCamp/out/production/JavaCamp/Week1/Hello/";
        URLClassLoader urlClassLoader  = (URLClassLoader) MyClassLoadAddURL.class.getClassLoader();
        try {
            Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addURL.setAccessible(true);
            URL url = new URL(appPath);
//            Hello h = new Hello();
//            addURL.invoke(h,null);
            addURL.invoke(urlClassLoader,url);
            Class.forName("Week1.Hello.Hello");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
