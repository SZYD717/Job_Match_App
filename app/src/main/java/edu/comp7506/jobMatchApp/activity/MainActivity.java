package edu.comp7506.jobMatchApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.job_match_app.R;

public class MainActivity extends AppCompatActivity {
    private int adminClickNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adminClickNum = 0;
    }
}