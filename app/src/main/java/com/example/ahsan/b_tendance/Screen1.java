package com.example.ahsan.b_tendance;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Screen1 extends Activity {
    Button mButton;
    EditText mEdit1, mEdit2, mEdit3;
    String Name, Address, Order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mEdit1 = (EditText) findViewById(R.id.edittext);
        mEdit2 = (EditText) findViewById(R.id.edittext2);
        mEdit3 = (EditText) findViewById(R.id.edittext3);
        mEdit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEdit1.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit3.getWindowToken(), 0);
                imm.showSoftInput(mEdit1, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(true);
                mEdit2.setCursorVisible(false);
                mEdit3.setCursorVisible(false);
            }
        });
        mEdit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit1.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit3.getWindowToken(), 0);
                mEdit2.requestFocus();
                imm.showSoftInput(mEdit2, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(false);
                mEdit2.setCursorVisible(true);
                mEdit3.setCursorVisible(false);

            }
        });
        mEdit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEdit3.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEdit2.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(mEdit1.getWindowToken(), 0);
                imm.showSoftInput(mEdit3, InputMethodManager.SHOW_IMPLICIT);
                mEdit1.setCursorVisible(false);
                mEdit2.setCursorVisible(false);
                mEdit3.setCursorVisible(true);
            }
        });
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Name = mEdit1.getText().toString();
                Address = mEdit2.getText().toString();
                Order = mEdit3.getText().toString();
                Toast.makeText(getApplicationContext(), "Order is placed", Toast.LENGTH_LONG).show();
            }
        });
    }

}
