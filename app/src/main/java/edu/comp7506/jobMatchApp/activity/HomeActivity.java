package edu.comp7506.jobMatchApp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

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
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.menu_connect:
                                selectedFragment = new ConnectFragment();
                                break;
                            case R.id.menu_resume:
                                selectedFragment = new ResumeFragment();
                                break;
                            case R.id.menu_personal:
                                selectedFragment = new PersonalFragment();
                                break;
                        }
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragmentContainerView, selectedFragment).commit();
                        return true;
                    }
                });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, new HomeFragment()).commit();
    }
}
