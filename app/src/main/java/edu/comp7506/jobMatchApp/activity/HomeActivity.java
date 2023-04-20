package edu.comp7506.jobMatchApp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.job_match_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation_view);



    }
}
