package edu.comp7506.jobMatchApp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

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
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        Intent intent = null;
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                intent = new Intent(HomeActivity.this, HomeActivity.class);
                                break;
                            case R.id.menu_connect:
                                intent = new Intent(HomeActivity.this, ConnectActivity.class);
                                break;
                            case R.id.menu_personal:
                                intent = new Intent(HomeActivity.this, PersonalActivity.class);
                                break;
                            case R.id.menu_resume:
                                intent = new Intent(HomeActivity.this, ResumeActivity.class);
                                break;
                        }
                        startActivity(intent);
                        return true;
                    }
                });
    }
}
