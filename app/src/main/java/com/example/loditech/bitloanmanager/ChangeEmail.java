package com.example.loditech.bitloanmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loditech.bitloanmanager.Data.RetrofitClient;
import com.example.loditech.bitloanmanager.Models.Account;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeEmail extends AppCompatActivity {
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_a);

        email = (EditText) findViewById(R.id.txtNewEmail);
        password = (EditText) findViewById(R.id.txtPassword1);
    }

    public void cmdUpdate(View v){
        if(Check()){
            Call<Boolean> call = RetrofitClient.getInstance().getAPI().ChangeEmail(Account.account.getID(), password.getText().toString(), email.getText().toString());
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(retrofit2.Call<Boolean> call, Response<Boolean> response) {
                    try {
                        if (response.body()) {
                            Toast.makeText(ChangeEmail.this, "Email Changed.", Toast.LENGTH_LONG).show();
                            email.getText().clear();
                            password.getText().clear();
                        } else {
                            Toast.makeText(ChangeEmail.this, "Incorrect Password.", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(ChangeEmail.this, e.toString(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<Boolean> call, Throwable t) {
                    Toast.makeText(ChangeEmail.this, "ERROR", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void cmdCancel(View v){
        Intent i = new Intent(ChangeEmail.this, SettingsMenu.class);
        startActivity(i);
    }

    public boolean Check(){
        if(!email.getText().toString().isEmpty()&&!email.getText().toString().equals(" ")&&!password.getText().toString().isEmpty()&&!password.getText().toString().equals(" ")){
            return true;
        }
        Toast.makeText(this, "Fill the required fields.", Toast.LENGTH_LONG).show();
        return false;
    }
}
