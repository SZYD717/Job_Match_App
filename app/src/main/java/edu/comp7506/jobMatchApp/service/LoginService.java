
package edu.comp7506.jobMatchApp.service;

import android.util.Log;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginService{
    public static int login(String username, String password) {
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
