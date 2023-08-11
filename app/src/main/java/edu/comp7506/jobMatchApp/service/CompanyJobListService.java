package edu.comp7506.jobMatchApp.service;

import edu.comp7506.jobMatchApp.VO.HomepageVO;
import edu.comp7506.jobMatchApp.model.Job;
import edu.comp7506.jobMatchApp.utils.JsonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CompanyJobListService implements Callable<List<Job>> {

    String companyId;

    public CompanyJobListService(String companyId) {
        this.companyId = companyId;
    }
    public List<Job> call() throws Exception {
        List<Job> jobList = new ArrayList<>();
        String urlStr = "http://192.168.1.109:8090/companyJobList/"+companyId;
        try {
            Request request = new Request.Builder().url(urlStr).get().build();
            Response response = new OkHttpClient().newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject ele = jsonArray.getJSONObject(i);
                jobList.add(JsonUtils.jsonToObject(ele.toString(), Job.class));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jobList;
    }
}
