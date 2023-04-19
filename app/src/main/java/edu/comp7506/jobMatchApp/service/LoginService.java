
package edu.comp7506.jobMatchApp.service;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.net.URL;
import edu.comp7506.jobMatchApp.activity.MainActivity;
import okhttp3.ResponseBody;
import okio.BufferedSink;

public class LoginService implements Runnable{
    private static String username;
    private static String password;
    private static int statusCode;

    public LoginService(String username, String psw){
        this.username = username;
        this.password = psw;
    }

    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public void run() {
        String urlStr = "http://192.168.3.7:8090/login";
        String requestBody = "?name="+username+"&password="+password;
        try {
            String URL = urlStr+requestBody;
            // 创建OKHTTP客户端
            OkHttpClient client = new OkHttpClient();

            // 创建HTTP请求
            Request request = new Request.Builder()
                    .url(URL)
                    .post(new RequestBody() {
                        @Nullable
                        @Override
                        public MediaType contentType() {
                            return null;
                        }

                        @Override
                        public void writeTo(@NonNull BufferedSink bufferedSink) throws IOException {

                        }
                    })
                    .build();
            Log.d("Login","建立完成");

            // 发送HTTP POST请求并获取服务器返回的响应
            Response response = client.newCall(request).execute();
            Log.d("Login","发送完成");
            // 获取响应体数据
            ResponseBody responseBody = response.body();

            // 将响应体数据解析为JSONObject对象
            JSONObject jsonObject = new JSONObject(responseBody.string());

            // 从JSONObject对象中获取值
            statusCode = jsonObject.getInt("status");
            Log.d("Login","Status"+statusCode);

        } catch (IOException e) {
            Log.i("Login",e.getMessage());
            Log.i("Login","Connect Error");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
