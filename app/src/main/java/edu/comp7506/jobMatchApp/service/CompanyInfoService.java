
package edu.comp7506.jobMatchApp.service;

import edu.comp7506.jobMatchApp.model.Company;
import edu.comp7506.jobMatchApp.utils.JsonUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.util.concurrent.Callable;

public class CompanyInfoService implements Callable<Company> {
    String companyId;

    public CompanyInfoService(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public Company call() throws Exception {
        Company company = null;
        String urlStr = "http://192.168.3.7:8090/company/";
        String requestBody = companyId;
        try {
            String URL = urlStr + requestBody;
            Request request = new Request.Builder().url(URL).build();
            Response response = new OkHttpClient().newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());
            company = JsonUtils.jsonToObject(jsonObject.getJSONObject("data").toString(), Company.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return company;
    }
}