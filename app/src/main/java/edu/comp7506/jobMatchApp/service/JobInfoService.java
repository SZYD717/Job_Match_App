package edu.comp7506.jobMatchApp.service;

import edu.comp7506.jobMatchApp.VO.JobVO;
import edu.comp7506.jobMatchApp.utils.JsonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.util.concurrent.Callable;

public class JobInfoService implements Callable<JobVO> {

    @Override
    public JobVO call() throws Exception {
        JobVO job = null;
        String urlStr = "http://192.168.3.7:8090/job/jobDetail?id=";
        String requestBody = "1";
        try {
            String URL = urlStr + requestBody;
            Request request = new Request.Builder().url(URL).build();
            Response response = new OkHttpClient().newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            String data = jsonObject.getJSONObject("data").toString();
            job = JsonUtils.jsonToObject(data, JobVO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return job;
    }
}
