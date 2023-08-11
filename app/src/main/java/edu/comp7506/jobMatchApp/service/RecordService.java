package edu.comp7506.jobMatchApp.service;

import android.util.Log;
import okhttp3.*;
import org.json.JSONObject;

import java.util.concurrent.Callable;

public class RecordService implements Callable<Integer> {
    private String resumeId;
    private String jobId;
    public RecordService(String resumeId, String jobId){
        this.resumeId = resumeId;
        this.jobId = jobId;
    }
    @Override
    public Integer call() throws Exception {
        int status = 0;
        String url = "http://192.168.1.109:8090/deliveryRecord/" + resumeId + "?jobId=" + jobId;
        try {
            JSONObject jsonObject = new JSONObject();
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = new OkHttpClient().newCall(request).execute();
            JSONObject res = new JSONObject(response.body().string());
            status = res.getInt("status");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
