
package edu.comp7506.jobMatchApp.service;

import android.util.Log;

import edu.comp7506.jobMatchApp.model.Company;
import edu.comp7506.jobMatchApp.model.Customer;
import edu.comp7506.jobMatchApp.utils.JsonUtils;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.util.concurrent.Callable;

public class LoginService implements Callable<Customer> {

    private final String username;
    private final String password;

    public LoginService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public Customer call() throws Exception {
        Customer user = null;
        String urlStr = "http://192.168.1.7:8090/login";
        String requestBody = "?name="+username+"&password="+password;
        try {
            String URL = urlStr + requestBody;
            Request request = new Request.Builder().url(URL).post(RequestBody.create("".getBytes())).build();
            Response response = new OkHttpClient().newCall(request).execute();

            JSONObject jsonObject = new JSONObject(response.body().string());
            if(jsonObject.getInt("status") == 1)
                user = JsonUtils.jsonToObject(jsonObject.getJSONObject("data").toString(), Customer.class);
            else
                return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
