package edu.comp7506.jobMatchApp.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import edu.comp7506.jobMatchApp.model.Job;
import edu.comp7506.jobMatchApp.model.Record;
import edu.comp7506.jobMatchApp.utils.JsonUtils;

public class DeliveryRecordListService implements Callable<List<Record>> {

    String id;
    String type;
    public DeliveryRecordListService(String id,String type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public List<Record> call() throws Exception {
        List<Record> recordList = new ArrayList<>();
        String urlStr = "http://192.168.3.7:8090/deliveryRecordList?"+"id="+id+"&type"+type;
        try {
            System.out.println("request");
            Request request = new Request.Builder().url(urlStr).get().build();
            System.out.println("requested");
            Response response = new OkHttpClient().newCall(request).execute();
            System.out.println("response");
            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject ele = jsonArray.getJSONObject(i);
                jobList.add(JsonUtils.jsonToObject(ele.toString(), Record.class));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jobList;
    }
}
