package com.example.loditech.bitloanmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SettingsMenu extends AppCompatActivity {
    Button cmdChangeEmail, cmdChangePassword, cmdUpdateInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);

        cmdChangeEmail = findViewById(R.id.cmdChangeEmail);
        cmdChangePassword = findViewById(R.id.cmdChangePassword);
        cmdUpdateInformation = findViewById(R.id.cmdUpdateInformation);
    }

    public void ChangeEmail(View v)
    {
        Intent intent = new Intent(SettingsMenu.this, ChangeEmail.class);
        startActivity(intent);
    }

    public void ChangePassword(View v)
    {
        Intent intent = new Intent(SettingsMenu.this, ChangePassword.class);
        startActivity(intent);
    }

    public void UpdateInformation(View v)
    {
        Intent intent = new Intent(SettingsMenu.this, UpdateInformation.class);
        startActivity(intent);
    }
}
