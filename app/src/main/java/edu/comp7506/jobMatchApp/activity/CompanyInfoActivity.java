package edu.comp7506.jobMatchApp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.job_match_app.R;
import edu.comp7506.jobMatchApp.model.Company;
import edu.comp7506.jobMatchApp.model.Job;
import edu.comp7506.jobMatchApp.service.CompanyInfoService;
import edu.comp7506.jobMatchApp.service.CompanyJobListService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

public class CompanyInfoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_info);

        TextView companyName = findViewById(R.id.company_name);
        TextView companyAttribute = findViewById(R.id.company_attribute);
        TextView companyWebsite = findViewById(R.id.company_official_website);
        TextView companyIntroduction = findViewById(R.id.company_introduction);
        String companyId = getIntent().getStringExtra("companyId");

        FutureTask<Company> task = new FutureTask<>(new CompanyInfoService(companyId));
        Thread thread = new Thread(task);
        thread.start();
        try {
            Company company = task.get();
            companyName.setText(company.getCompanyName());
            companyAttribute.setText(company.getCompanyStage()+"  |  "+company.getCompanyIndustry());
            companyWebsite.setText(company.getCompanyWebsite());
            companyIntroduction.setText(company.getCompanyDesc());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        FutureTask<List<Job>> listTask = new FutureTask<>(new CompanyJobListService(companyId));
        Thread listThread = new Thread(listTask);
        listThread.start();
        TableLayout tableLayout = findViewById(R.id.job_item);

        try {
            List<Job> jobList = listTask.get();
            for (Job job : jobList) {

                TableRow tableRow = new TableRow(this);
                tableRow.setOnClickListener(view -> {
                    Intent jobIntent = new Intent(view.getContext(), JobDetailActivity.class);
                    jobIntent.putExtra("jobId",job.getJobId());
                    view.getContext().startActivity(jobIntent);
                });

                TextView jobName = new TextView(this);
                TextView jobSalary = new TextView(this);
                TextView jobCity = new TextView(this);

                jobName.setText(job.getJobName());
                jobName.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                jobSalary.setText(job.getJobMinSalary() / 1000 + "K-" + job.getJobMaxSalary() / 1000 + "K");
                jobSalary.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                jobCity.setText(job.getJobCity());
                jobCity.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                tableRow.addView(jobName);
                tableRow.addView(jobSalary);
                tableRow.addView(jobCity);

                tableLayout.addView(tableRow);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
