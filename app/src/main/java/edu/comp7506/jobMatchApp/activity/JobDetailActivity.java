package edu.comp7506.jobMatchApp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.job_match_app.R;
import edu.comp7506.jobMatchApp.VO.JobVO;
import edu.comp7506.jobMatchApp.model.Company;
import edu.comp7506.jobMatchApp.service.CompanyInfoService;
import edu.comp7506.jobMatchApp.service.JobInfoService;

import java.util.concurrent.FutureTask;

public class JobDetailActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info);

        TextView jobName = findViewById(R.id.job_name);
        TextView jobSalary = findViewById(R.id.job_salary);
        TextView jobDetail = findViewById(R.id.job_detailInfo);
        TextView positionInfo = findViewById(R.id.position_info);
        TextView positionRequirement = findViewById(R.id.position_requirement);
        TextView workPlace = findViewById(R.id.job_info_jobCityText);
        TextView referralInfo = findViewById(R.id.referralInfo);
        ImageView imageView = findViewById(R.id.company_image);
        TextView company_name1 = findViewById(R.id.job_info_company_name);
        Button view_company_positions = findViewById(R.id.view_company_positions);
        String companyId = null;
        String jobId = getIntent().getStringExtra("jobId");

        FutureTask<JobVO> jobTask = new FutureTask<>(new JobInfoService(jobId));
        Thread jobThread = new Thread(jobTask);
        jobThread.start();
        try {
            JobVO job = jobTask.get();
            jobName.setText(job.getJobName());
            jobSalary.setText(job.getJobMinSalary()+" - "+job.getJobMaxSalary());
            switch (job.getJobDegree()){
                case "1": job.setJobDegree("Bachelor"); break;
                case "2": job.setJobDegree("Master"); break;
                case "3": job.setJobDegree("Doctor"); break;
                case "0": job.setJobDegree("No Degree"); break;
            }
            job.setJobPublishTime(job.getJobPublishTime().split("T")[0]);
            jobDetail.setText(job.getJobYear()+" Years | "+job.getJobDegree()+" | "+ job.getJobNeedNumber() + " vacancies | " + job.getJobPublishTime() + " Published");
            positionInfo.setText(job.getJobDuty());
            positionRequirement.setText(job.getJobDemand());
            workPlace.setText(job.getJobAddress());
            companyId = job.getCompanyId();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(companyId!=null) {
            FutureTask<Company> task = new FutureTask<>(new CompanyInfoService(companyId));
            Thread thread = new Thread(task);
            thread.start();
            try {
                Company company = task.get();
                company_name1.setText(company.getCompanyName());
                Intent companyIntent = new Intent(this,CompanyInfoActivity.class);
                companyIntent.putExtra("companyId",companyId);
                view_company_positions.setOnClickListener(view -> {
                    startActivity(companyIntent);
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
