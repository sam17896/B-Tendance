package com.example.ahsan.b_tendance;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
        SharedPreferences prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        boolean haveWeShownPreferences = prefs.getBoolean("HaveShownPrefs", false);
        if (!haveWeShownPreferences) {
            Thread time = new Thread() {
                public void run() {

                    try {
                        sleep(2000);
                    } catch (InterruptedException e)

                    {
                        e.printStackTrace();
                    } finally {
                        Intent i = new Intent("com.example.ahsan.b_tendance.SCREEN1");
                        startActivity(i);
                    }
                }


            };
            time.start();
        } else {

            Thread time = new Thread() {
                public void run() {

                    try {
                        sleep(2000);

                    } catch (InterruptedException e)

                    {
                        e.printStackTrace();
                    } finally {
                        Intent i = new Intent("com.example.ahsan.b_tendance.SCREEN2");
                        startActivity(i);
                    }
                }
            };
            time.start();
        }
    }

}