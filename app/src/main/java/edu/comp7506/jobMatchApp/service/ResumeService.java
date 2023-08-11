package edu.comp7506.jobMatchApp.service;

import edu.comp7506.jobMatchApp.model.Record;
import edu.comp7506.jobMatchApp.model.Resume;
import edu.comp7506.jobMatchApp.utils.JsonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ResumeService implements Callable<List<Resume>> {

    private final String userId;

    public ResumeService(String userId) {
        this.userId = userId;
    }

    @Override
    public List<Resume> call() throws Exception {
        List<Resume> resumeList = new ArrayList<>();
        String urlStr = "http://192.168.1.109:8090/resumeList?id=";
        try {
            String URL = urlStr + userId;
            Request request = new Request.Builder().url(URL).build();
            Response response = new OkHttpClient().newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject ele = jsonArray.getJSONObject(i);
                Resume resume = JsonUtils.jsonToObject(ele.toString(), Resume.class);
                resumeList.add(resume);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resumeList;
    }
}
