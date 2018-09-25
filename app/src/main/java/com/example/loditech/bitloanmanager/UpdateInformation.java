package com.example.loditech.bitloanmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loditech.bitloanmanager.Data.RetrofitClient;
import com.example.loditech.bitloanmanager.Models.Account;

import retrofit2.Callback;
import retrofit2.Response;

public class UpdateInformation extends AppCompatActivity {
    EditText fName, mName, lName, address, city, province;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_c);

        fName = (EditText) findViewById(R.id.txtFName);
        mName = (EditText) findViewById(R.id.txtMName);
        lName = (EditText) findViewById(R.id.txtLName);
        address = (EditText) findViewById(R.id.txtAddress);
        city = (EditText) findViewById(R.id.txtCity);
        province = (EditText) findViewById(R.id.txtProvince);

        fName.setText(Account.account.getFirstName());
        mName.setText(Account.account.getMiddleName());
        lName.setText(Account.account.getLastName());
        String[] address1 = Account.account.getAddress().split(", ");
        address.setText(address1[0]);
        city.setText(address1[1]);
        province.setText(address1[2]);
    }

    public void UpdateInfo(View v){
        if(Check()){
            Account account = new Account(Account.account.getID(),"","",fName.getText().toString(),mName.getText().toString(),lName.getText().toString(),"",address.getText().toString()+", "+city.getText().toString()+", "+province.getText().toString(),"");
            retrofit2.Call<Boolean> call = RetrofitClient.getInstance().getAPI().UpdateInformation(account);
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(retrofit2.Call<Boolean> call, Response<Boolean> response) {
                    try{
                        if(response.body()){
                            Account.account.setFirstName(fName.getText().toString());
                            Account.account.setMiddleName(mName.getText().toString());
                            Account.account.setLastName(lName.getText().toString());
                            Account.account.setAddress(address.getText().toString()+", "+city.getText().toString()+", "+province.getText().toString());
                        }
                    }catch (Exception e){
                        Toast.makeText(UpdateInformation.this, e.toString(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(retrofit2.Call<Boolean> call, Throwable t) {
                    Toast.makeText(UpdateInformation.this, "ERROR", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    public void CancelUpdateInfo(View v){
        Intent i = new Intent(UpdateInformation.this, SettingsMenu.class);
        startActivity(i);
    }

    public boolean Check(){
        if(!fName.getText().toString().isEmpty()&&!fName.getText().toString().equals(" ")&&!lName.getText().toString().isEmpty()&&!lName.getText().toString().equals(" ")&&!address.getText().toString().isEmpty()&&!address.getText().toString().equals(" ")&&!city.getText().toString().isEmpty()&&!city.getText().toString().equals(" ")&&!province.getText().toString().isEmpty()&&!province.getText().toString().equals(" ")){
            return true;
        }
        Toast.makeText(this, "Fill the required fields", Toast.LENGTH_LONG).show();
        return false;
    }
}
