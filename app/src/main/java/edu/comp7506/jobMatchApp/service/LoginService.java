
package edu.comp7506.jobMatchApp.service;

import android.util.Log;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.concurrent.Callable;

public class LoginService implements Callable<Integer> {

    private final String username;
    private final String password;

    public LoginService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Integer call() throws Exception {
        int statusCode = 0;
        String urlStr = "http://192.168.3.7:8090/login";
        String requestBody = "?name="+username+"&password="+password;
        try {
            String URL = urlStr + requestBody;
            Request request = new Request.Builder().url(URL).post(RequestBody.create("".getBytes())).build();
            Response response = new OkHttpClient().newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            statusCode = jsonObject.getInt("status");
            Log.d("Login","Status "+ statusCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return statusCode;
    }
}
