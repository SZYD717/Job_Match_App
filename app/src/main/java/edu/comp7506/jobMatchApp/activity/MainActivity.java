package edu.comp7506.jobMatchApp.activity;

import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.comp7506.jobMatchApp.model.Customer;
import edu.comp7506.jobMatchApp.service.LoginService;
import com.example.job_match_app.R;

import edu.comp7506.jobMatchApp.service.LoginService;
import edu.comp7506.jobMatchApp.utils.JsonUtils;

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
            FutureTask<Customer> loginTask = new FutureTask<>(loginService);
            Thread thread = new Thread(loginTask);
            thread.start();
            try {
                Customer user = loginTask.get();
                if(user!=null){
                    Toast t = Toast.makeText(getApplicationContext(),"Login Success!",Toast.LENGTH_SHORT);
                    t.show();
                    SharedPreferences sharedPreferences = getSharedPreferences("cache", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("user", JsonUtils.toJSONString(user));
                    editor.apply();
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