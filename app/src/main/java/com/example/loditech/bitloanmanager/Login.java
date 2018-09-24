package com.example.loditech.bitloanmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText txtUsername, txtPassword;
    Button cmdLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUsername = (EditText)findViewById(R.id.txtUsername);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        cmdLogin = (Button)findViewById(R.id.cmdLogin);
    }

    public void Login(View v) {
        if (Check())
        {


        }
    }

    public boolean Check(){
        if(!txtUsername.getText().toString().isEmpty()&&!txtUsername.getText().toString().equals(" ")&&!txtPassword.getText().toString().isEmpty()&&!txtPassword.getText().toString().equals(" ")){
            return true;
        }
        return false;
    }
}
