package com.example.loditech.bitloanmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class LoanApplication extends AppCompatActivity
{
    EditText loanRequested, loanAmount, loanReason;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_application);

        loanRequested = (EditText) findViewById(R.id.txtLoanRequested);
        loanAmount = (EditText) findViewById(R.id.txtLoanAmount);
        loanReason = (EditText) findViewById(R.id.txtLoanReason);

        Populate();
    }

    public void Populate()
    {
        //Populate all the textboxes
        Bundle getBundle = getIntent().getExtras();

        loanRequested.setText(getBundle.getString("loanRequestedBy"));
        loanAmount.setText(getBundle.getString("loanAmount"));
        loanReason.setText(getBundle.getString("loanReason"));
    }

    public void ApproveLoan()
    {

    }

    public void DeclineLoan()
    {

    }
}
