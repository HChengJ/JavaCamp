package Week1.CalssLoader;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class MyClassLoad extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String str = "yv66vgAAADQAHwoABgARCQASABMIABQKABUAFgcAFwcAGAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQANTFdlZWsxL0hlbGxvOwEACDxjbGluaXQ+AQAKU291cmNlRmlsZQEACkhlbGxvLmphdmEMAAcACAcAGQwAGgAbAQAYSGVsbG8gQ2xhc3MgSW5pdGlhbGl6ZWQhBwAcDAAdAB4BAAtXZWVrMS9IZWxsbwEAEGphdmEvbGFuZy9PYmplY3QBABBqYXZhL2xhbmcvU3lzdGVtAQADb3V0AQAVTGphdmEvaW8vUHJpbnRTdHJlYW07AQATamF2YS9pby9QcmludFN0cmVhbQEAB3ByaW50bG4BABUoTGphdmEvbGFuZy9TdHJpbmc7KVYAIQAFAAYAAAAAAAIAAQAHAAgAAQAJAAAALwABAAEAAAAFKrcAAbEAAAACAAoAAAAGAAEAAAADAAsAAAAMAAEAAAAFAAwADQAAAAgADgAIAAEACQAAACUAAgAAAAAACbIAAhIDtgAEsQAAAAEACgAAAAoAAgAAAAUACAAGAAEADwAAAAIAEA==";
        byte[] bytes =decode(str);
        return defineClass(name,bytes,0,bytes.length);
    }

    public byte[] decode(String base64){
        return Base64.getDecoder().decode(base64);
    }

    public static void main(String[] args) {
//        String str = getFileStr("F:/IdeaWorkSpace/JavaCamp/out/production/JavaCamp/Week1/Hello/Hello.class");
//        System.out.println(str);

        try {
            new MyClassLoad().findClass("Week1.Hello").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * 文件转化成base64字符串
     * 将文件转化为字节数组字符串，并对其进行Base64编码处理
     */
    public static String getFileStr(String filePath) {
        InputStream in = null;
        byte[] data = null;
        // 读取文件字节数组
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
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回 Base64 编码过的字节数组字符串
        return encoder.encode(data);
    }

}
