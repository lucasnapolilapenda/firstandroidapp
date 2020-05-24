package com.google.codelabs.mdc.java.myatm.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.codelabs.mdc.java.shrine.R;

public class MainActivity extends AppCompatActivity implements Calculations {
    TextView boxAccount;
    TextView boxHand;
    Button depositBtn;
    Button withdrawBtn;
    Spinner transaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shr_atm_fragment);

        transaction = (Spinner) findViewById(R.id.transactionAmount);
        boxAccount = (TextView) findViewById(R.id.box_account);
        boxHand = (TextView) findViewById(R.id.box_hand);
        depositBtn = (Button) findViewById(R.id.deposit_button);
        withdrawBtn = (Button) findViewById(R.id.withdraw_button);


    }

    @Override
    public int [] transaction(int des, int src, int tran) {
        int [] arr = {des,src};
        if (src>=tran && src>1000) {
            arr[0] = des + tran;
            arr[1] = src - tran;
        }
        return arr;
    }

    public void onClickDeposit (View view) {
        int trans = Integer.parseInt(transaction.getSelectedItem().toString());
        int acc = Integer.parseInt(boxAccount.getText().toString());
        int hand = Integer.parseInt(boxHand.getText().toString());

        int [] arr = transaction(acc, hand, trans);
        boxAccount.setText(arr[0] + "");
        boxHand.setText(arr[1] + "");
    }

    public void onClickWithdraw (View view) {

        int trans = Integer.parseInt(this.transaction.getSelectedItem().toString());
        int acc = Integer.parseInt(boxAccount.getText().toString());
        int hand = Integer.parseInt(boxHand.getText().toString());

        int [] arr = transaction(hand, acc, trans);
        boxAccount.setText(arr[1] + "");
        boxHand.setText(arr[0] + "");
    }
}
