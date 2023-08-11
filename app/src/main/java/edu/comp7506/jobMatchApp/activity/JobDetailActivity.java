package edu.comp7506.jobMatchApp.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.job_match_app.R;
import edu.comp7506.jobMatchApp.VO.JobVO;
import edu.comp7506.jobMatchApp.model.Company;
import edu.comp7506.jobMatchApp.model.Customer;
import edu.comp7506.jobMatchApp.model.Resume;
import edu.comp7506.jobMatchApp.model.ResumeDeliveryRecord;
import edu.comp7506.jobMatchApp.service.CompanyInfoService;
import edu.comp7506.jobMatchApp.service.JobInfoService;
import edu.comp7506.jobMatchApp.service.RecordService;
import edu.comp7506.jobMatchApp.service.ResumeService;
import edu.comp7506.jobMatchApp.utils.JsonUtils;

import java.net.URL;
import java.util.List;
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
        TextView company_name1 = findViewById(R.id.job_info_company_name);
        Button view_company_positions = findViewById(R.id.view_company_positions);
        Button apply = findViewById(R.id.apply_position);
        String companyId = null;
        String jobId = getIntent().getStringExtra("jobId");

        apply.setOnClickListener(view -> {
            //点击后弹窗
            this.dialog(view);
        });



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
            URL url = null;
            try {
                url = new URL(job.getCompanyLogo());
                requestImg(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            workPlace.setText(job.getJobCity());
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
    private void requestImg(final URL imgUrl)
    {
        new Thread(() -> {
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(imgUrl.openStream());
                showImg(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    private void showImg(final Bitmap bitmap){
        runOnUiThread(() -> {
            ImageView imageView = findViewById(R.id.company_image);
            imageView.setImageBitmap(bitmap);});
    }

    public void dialog(View view){
        //创建一个警告对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("投递确认");
        builder.setMessage("是否要投递该岗位？");

        AlertDialog.Builder builder1 = builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences sharedPreferences = view.getContext(). getSharedPreferences("cache", MODE_PRIVATE);
                String userString = sharedPreferences.getString("user", null);
                try {
                    Customer user = JsonUtils.jsonToObject(userString,Customer.class);
                    ResumeService resumeService = new ResumeService(user.getCustomerId());
                    FutureTask<List<Resume>> task = new FutureTask<>(resumeService);
                    Thread thread = new Thread(task);
                    thread.start();
                    List<Resume> resumes = task.get();
                    String resumeId = null;
                    if(resumes.size()!=0)
                        resumeId = resumes.get(0).getResumeId();
                    String jobId = getIntent().getStringExtra("jobId");
                    RecordService recordService = new RecordService(resumeId,jobId);
                    FutureTask<Integer> recordTask = new FutureTask<>(recordService);
                    Thread recordThread = new Thread(recordTask);
                    recordThread.start();
                    Toast.makeText(JobDetailActivity.this,"投递成功",Toast.LENGTH_SHORT).show();
                    //跳转
                    Intent homeIntent = new Intent(JobDetailActivity.this,HomeActivity.class);
                    startActivity(homeIntent);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(JobDetailActivity.this,"取消投递",Toast.LENGTH_SHORT).show();

            }
        });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }
}
