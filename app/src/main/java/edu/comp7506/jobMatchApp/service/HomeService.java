package edu.comp7506.jobMatchApp.service;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

import edu.comp7506.jobMatchApp.VO.HomepageVO;
import edu.comp7506.jobMatchApp.model.Company;
import edu.comp7506.jobMatchApp.model.Job;
import edu.comp7506.jobMatchApp.utils.JsonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeService implements Callable<List<HomepageVO>> {
    @Override
    public List<HomepageVO> call() throws Exception {
        List<HomepageVO> jobList = new LinkedList<>();
        String urlStr = "http://192.168.1.7:8090/HomePageJobs";
        int statusCode;
        try {
            String URL = urlStr;
            Request request = new Request.Builder().url(URL).get().build();
            Response response = new OkHttpClient().newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            //解析json data
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject ele = jsonArray.getJSONObject(i);
                jobList.add(JsonUtils.jsonToObject(ele.toString(), HomepageVO.class));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jobList;
    }
}
