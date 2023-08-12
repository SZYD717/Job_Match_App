package edu.comp7506.jobMatchApp.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import edu.comp7506.jobMatchApp.model.Job;
import edu.comp7506.jobMatchApp.model.Record;
import edu.comp7506.jobMatchApp.utils.JsonUtils;

public class DeliveryRecordListService implements Callable<List<Record>> {

    String id;
    public DeliveryRecordListService(String id) {
        this.id = id;
    }

    @Override
    public List<Record> call() throws Exception {
        List<Record> recordList = new ArrayList<>();
        String urlStr = "http://192.168.1.7:8090/deliveryRecordList?"+"id="+id+"&type"+"";
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
                recordList.add(JsonUtils.jsonToObject(ele.toString(), Record.class));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return recordList;
    }
}
