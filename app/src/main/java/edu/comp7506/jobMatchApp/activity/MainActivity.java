package edu.comp7506.jobMatchApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.comp7506.jobMatchApp.service.LoginService;
import com.example.job_match_app.R;

import edu.comp7506.jobMatchApp.service.LoginService;

public class MainActivity extends AppCompatActivity {
    private int adminClickNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get items in this activity
        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        //intent
        Intent userIntent = new Intent(this,UserActivity.class);
        Intent registerIntent = new Intent(this,RegisterActivity.class);
        loginButton.setOnClickListener(view -> {
            if(LoginService.login(username.getText().toString(),password.getText().toString())==1){
                Toast t = Toast.makeText(getApplicationContext(),"Login Success!",Toast.LENGTH_SHORT);
                t.show();
                startActivity(userIntent);
            }
            else{
                Toast t = Toast.makeText(getApplicationContext(),"Wrong username of password",Toast.LENGTH_LONG);
                t.show();
            }
        });
    }
}