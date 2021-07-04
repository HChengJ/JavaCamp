package Week1.Work;

import sun.misc.BASE64Encoder;

import javax.sound.midi.Soundbank;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Base64;

public class WorkClassLoad extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] oldBytes = getFileBytes("F:/IdeaWorkSpace/JavaCamp/Work/Week1/Hello.xlass");
        byte[] newBytes = new byte[oldBytes.length];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<oldBytes.length;i++){
            newBytes[i] = (byte)(255- oldBytes[i]);
        }
        System.out.println("读取的byte[]："+new String(oldBytes));
        System.out.println("调整后的byte[]："+new String(newBytes));
        return defineClass(name,newBytes,0,newBytes.length);

    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }

    public static void main(String[] args) {
        try {
            Class c = new WorkClassLoad().findClass("Hello");
           /* Method[] methods = c.getMethods();
            for(int i=0;i<methods.length;i++){
                StringBuilder sb = new StringBuilder();
                Method m = methods[i];
                sb.append("方法名："+m.getName());
                Class<?>[] rarameterTypes = m.getParameterTypes();
                sb.append("(");
                for(Class<?> rarameterType : rarameterTypes){
                    sb.append("参数："+rarameterType.getSimpleName());
                    sb.append(",");
                }
                if(sb.lastIndexOf(",") > -1){
                    sb.delete(sb.length() -1,sb.length());
                }
                sb.append(")");
                System.out.println(sb.toString());
            }*/

            Method helloMethod = c.getMethod("hello");
            helloMethod.setAccessible(true);
            helloMethod.invoke(c.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static byte[] getFileBytes(String filePath) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(filePath);
            data = new byte[in.available()];
            int read = in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

}
