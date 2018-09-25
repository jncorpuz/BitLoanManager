package com.example.loditech.bitloanmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.loditech.bitloanmanager.Models.Account;

public class Home extends AppCompatActivity {
    TextView lblName, lblEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_menu);

        lblName = findViewById(R.id.lblName);
        lblEmail = findViewById(R.id.lblEmail);

        lblName.setText(Account.account.getName());
        lblEmail.setText(Account.account.getEmailAddress());
    }
}
