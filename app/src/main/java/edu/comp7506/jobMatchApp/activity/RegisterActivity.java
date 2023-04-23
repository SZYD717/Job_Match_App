package edu.comp7506.jobMatchApp.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.job_match_app.R;

import java.util.concurrent.FutureTask;

import edu.comp7506.jobMatchApp.service.RegisterService;

public class RegisterActivity extends AppCompatActivity {
    private EditText usernameText;
    private EditText phoneText;
    private EditText mailText;
    private EditText passwordText;
    private EditText passwordConfirmText;
    private TextView passwordConfirmHint;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent loginIntent = new Intent(this,MainActivity.class);
        // 在onCreate方法中获取所有EditText对象
        usernameText = findViewById(R.id.register_usernameText);
        phoneText = findViewById(R.id.register_phoneText);
        mailText = findViewById(R.id.register_mailText);
        passwordText = findViewById(R.id.register_passwordText);
        passwordConfirmText = findViewById(R.id.register_passwordConfirmText);
        passwordConfirmHint = findViewById(R.id.register_passwordConfirmHint);

        Button registerButton = findViewById(R.id.register_registerButton);

        registerButton.setOnClickListener(view -> {
            RegisterService registerService = new RegisterService(
                    mailText.getText().toString(),
                    phoneText.getText().toString(),
                    usernameText.getText().toString(),
                    passwordText.getText().toString());
            FutureTask<Integer> registerTask = new FutureTask<>(registerService);
            Thread t = new Thread(registerTask);
            t.start();
            try{
                int status = registerTask.get();
                if(status==1){
                    Toast toast = Toast.makeText(getApplicationContext(),"Register Success!",Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(loginIntent);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Username been used, try another one",Toast.LENGTH_LONG);
                    toast.show();
                }
            }catch (Exception e){
                Log.e("RegisterTaskCall",e.getMessage());
            }

        });

        passwordConfirmText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(passwordText.getText().toString().equals(passwordConfirmText.getText().toString())){
                    passwordConfirmHint.setVisibility(View.INVISIBLE);
                }
                else{
                    passwordConfirmHint.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(passwordText.getText().toString().equals(passwordConfirmText.getText().toString())){
                    passwordConfirmHint.setVisibility(View.INVISIBLE);
                }
                else{
                    passwordConfirmHint.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(passwordText.getText().toString().equals(passwordConfirmText.getText().toString())){
                    passwordConfirmHint.setVisibility(View.INVISIBLE);
                }
                else{
                    passwordConfirmHint.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
