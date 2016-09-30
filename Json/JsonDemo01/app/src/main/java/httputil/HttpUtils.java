package httputil;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 建立网络连接
 * Created by FanFF on 2016/2/2.
 */
public class HttpUtils {
    public HttpUtils() {
    }
    /**
     * 通过URL获取服务器端通过JSon传来的数据
     * @param url_path
     * @return
     */
    public static String getJsonContent(String url_path){
        String jsonString = "";
        try {
            URL url = new URL(url_path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
           // 设置连接属性
            connection.setConnectTimeout(3000);// 超时
            connection.setRequestMethod("GET");
            connection.setDoInput(true);// 输入流
            int code = connection.getResponseCode();
            if (code == 200){
               jsonString = changeInputStream(connection.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("获取网络连接失败!");
        }
        return jsonString;
    }

    /**
     * 将输入流转换为字符串
     * @param inputStream
     * @return
     */
    private static String changeInputStream(InputStream inputStream) {
        String jsonString = "";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int len = 0;
        byte[] data = new byte[1024];
        try {
            while ((len = inputStream.read(data))!=-1){// 从inputsteam流中读取数据到data数组中
                outputStream.write(data, 0, len);// 将已经写入到data数组中的字节流写入到outputStream流中
            }
            // 利用输入流的toByteArrar()方法转换成字节数组
            // 然后利用String的构造函数
            jsonString = new String(outputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
