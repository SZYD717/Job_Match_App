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

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
        Intent homeIntent = new Intent(this,HomeActivity.class);
        Intent registerIntent = new Intent(this,RegisterActivity.class);
        loginButton.setOnClickListener(view -> {
            LoginService loginService = new LoginService(username.getText().toString(),password.getText().toString());
            FutureTask<Integer> loginTask = new FutureTask<>(loginService);
            Thread thread = new Thread(loginTask);
            thread.start();
            try {
                if(loginTask.get()==1){
                    Toast t = Toast.makeText(getApplicationContext(),"Login Success!",Toast.LENGTH_SHORT);
                    t.show();
                    startActivity(homeIntent);
                }
                else{
                    Toast t = Toast.makeText(getApplicationContext(),"Wrong username of password",Toast.LENGTH_LONG);
                    t.show();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}