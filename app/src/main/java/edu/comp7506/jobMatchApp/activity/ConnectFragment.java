package edu.comp7506.jobMatchApp.activity;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.job_match_app.R;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import edu.comp7506.jobMatchApp.VO.JobVO;
import edu.comp7506.jobMatchApp.model.Company;
import edu.comp7506.jobMatchApp.model.Customer;
import edu.comp7506.jobMatchApp.model.Record;
import edu.comp7506.jobMatchApp.service.CompanyInfoService;
import edu.comp7506.jobMatchApp.service.DeliveryRecordListService;
import edu.comp7506.jobMatchApp.service.JobInfoService;
import edu.comp7506.jobMatchApp.utils.JsonUtils;

public class ConnectFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connect, container, false);
        TableLayout deliveryRecordTable = view.findViewById(R.id.delivery_record_table);
        SharedPreferences sharedPreferences = view.getContext().getSharedPreferences("cache", MODE_PRIVATE);
        String userString = sharedPreferences.getString("user", null);
        Customer user = null;
        try {
            user = JsonUtils.jsonToObject(userString, Customer.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //创建获取record记录的线程
        FutureTask<List<Record>> recordFutureTask = new FutureTask<>(new DeliveryRecordListService(user.getCustomerId()));
        Thread thread = new Thread(recordFutureTask);
        thread.start();
        try {
            List<Record> recordList = recordFutureTask.get();
            //装载record记录到页面
            for (int i = 0; i < recordList.size(); i++) {
                TableRow tableRow = new TableRow(view.getContext());
                TextView positionName = new TextView(view.getContext());
                TextView companyName = new TextView(view.getContext());
                TextView date = new TextView(view.getContext());

                positionName.setText(recordList.get(i).getJobName());
                companyName.setText(recordList.get(i).getCompanyName());
                date.setText(recordList.get(i).getDeliveryTime());

                tableRow.addView(positionName);
                tableRow.addView(companyName);
                tableRow.addView(date);
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return view;
    }
}
