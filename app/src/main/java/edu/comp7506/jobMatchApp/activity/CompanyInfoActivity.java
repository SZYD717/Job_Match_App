package edu.comp7506.jobMatchApp.activity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.job_match_app.R;
import edu.comp7506.jobMatchApp.model.Company;
import edu.comp7506.jobMatchApp.service.CompanyInfoService;

import java.util.concurrent.FutureTask;

public class CompanyInfoActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_info);

        TextView companyName = findViewById(R.id.company_name);
        TextView companyAttribute = findViewById(R.id.company_attribute);
        TextView companyWebsite = findViewById(R.id.company_official_website);


        FutureTask<Company> task = new FutureTask<>(new CompanyInfoService());
        Thread thread = new Thread(task);
        thread.start();
        try {
            Company company = task.get();
            companyName.setText(company.getCompanyName());
            companyAttribute.setText(company.getCompanyStage()+"  |  "+company.getCompanyIndustry());
            companyWebsite.setText(company.getCompanyWebsite());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
