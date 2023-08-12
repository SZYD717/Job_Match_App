package edu.comp7506.jobMatchApp.service;

import android.app.DownloadManager;
import android.util.Log;

import org.json.JSONObject;

import java.util.concurrent.Callable;

import edu.comp7506.jobMatchApp.activity.RegisterActivity;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RegisterService implements Callable<Integer> {
    private String email;
    private String phone;
    private String username;
    private Long psw;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public RegisterService(String email, String phone, String username, String psw){
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.psw = Long.parseLong(psw);
    }
    @Override
    public Integer call() throws Exception {
        int status = 0;
        String url = "http://192.168.1.7:8090/register";

        //request body
        /*
        "": "string",
  "customerId": "000",
  "customerName": "string",
  "customerPassword": "000",
  "customerRegisterTime": "2023-04-23T03:17:26.178Z",
  "customerTele": 0,
  "status": 0
         */
        JSONObject requestJson = new JSONObject();
        requestJson.put("customerEmail",email);
        requestJson.put("customerTele",phone);
        requestJson.put("customerName",username);
        requestJson.put("customerPassword",psw);
        RequestBody requestBody = RequestBody.create(JSON,requestJson.toString());
        try{
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = new OkHttpClient().newCall(request).execute();
            JSONObject responseJson = new JSONObject(response.body().string());
            status = responseJson.getInt("status");
        }catch (Exception e){
            Log.e("Register",e.getMessage());
        }
        return status;
    }
}
