package com.example.loditech.bitloanmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loditech.bitloanmanager.Data.RetrofitClient;
import com.example.loditech.bitloanmanager.Models.Account;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePassword extends AppCompatActivity {
    EditText oldPassword, newPassword, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_b);

        oldPassword = (EditText) findViewById(R.id.txtOldPassword);
        newPassword = (EditText) findViewById(R.id.txtNewPassword);
        confirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
    }

    public void UpdatePassword(View v){
        if(Check()) {
            Call<Boolean> call = RetrofitClient.getInstance().getAPI().ChangePassword(Account.account.getID(), oldPassword.getText().toString(), newPassword.getText().toString());
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    try {
                        if (response.body()) {
                            Toast.makeText(ChangePassword.this, "Changed Password", Toast.LENGTH_LONG).show();
                            oldPassword.getText().clear();
                            newPassword.getText().clear();
                            confirmPassword.getText().clear();
                        } else {
                            Toast.makeText(ChangePassword.this, "Incorrect Password", Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(ChangePassword.this, e.toString(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Toast.makeText(ChangePassword.this, "ERROR", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void CancelChangePassword(View v){
        Intent i = new Intent(ChangePassword.this, SettingsMenu.class);
        startActivity(i);
    }

    public boolean Check(){
        if(!oldPassword.getText().toString().isEmpty()&&!oldPassword.getText().toString().equals(" ")&&!newPassword.getText().toString().isEmpty()&&!newPassword.getText().toString().equals(" ")&&!confirmPassword.getText().toString().isEmpty()&&!confirmPassword.getText().toString().equals(" ")){
            if(newPassword.getText().toString().equals(confirmPassword.getText().toString())){
                return true;
            }else{
                Toast.makeText(this,"Password not the same.", Toast.LENGTH_LONG).show();
            }
        }
        Toast.makeText(this, "Fill the required fields.", Toast.LENGTH_LONG).show();
        return false;
    }
}
