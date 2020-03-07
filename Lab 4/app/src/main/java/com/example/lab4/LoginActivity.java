package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_items);
        email = (EditText)findViewById(R.id.Email);
        password = (EditText)findViewById(R.id.Password);
        login = (Button)findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryToLogIn(email.getText().toString(),password.getText().toString());
            }
        });
    }
    private void tryToLogIn(String email,String password){
        if(email.equals("baha_mara01@mail.ru") && password.equals("babah")){
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }else {
            login.setEnabled(false);
         }
    }
}
