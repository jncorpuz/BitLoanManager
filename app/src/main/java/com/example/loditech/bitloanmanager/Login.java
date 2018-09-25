package com.example.loditech.bitloanmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loditech.bitloanmanager.Data.RetrofitClient;
import com.example.loditech.bitloanmanager.Models.Account;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            Call<Account> call = RetrofitClient.getInstance().getAPI().LoginUser(txtUsername.getText().toString(), txtPassword.getText().toString());
            call.enqueue(new Callback<Account>()
            {

                @Override
                public void onResponse(Call<Account> call, Response<Account> response)
                {
                    Account account = response.body();

                    if (account != null && response.code() == 200)
                    {
                        Account.account = account;
                        Intent intent = new Intent(Login.this, Home.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        txtUsername.getText().clear();
                        txtPassword.getText().clear();
                    }
                }

                @Override
                public void onFailure(Call<Account> call, Throwable t)
                {
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            Toast.makeText(Login.this, "Fill Username and Password", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean Check(){
        if(!txtUsername.getText().toString().isEmpty()&&!txtUsername.getText().toString().equals(" ")&&!txtPassword.getText().toString().isEmpty()&&!txtPassword.getText().toString().equals(" ")){
            return true;
        }
        return false;
    }
}
