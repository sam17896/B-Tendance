package com.example.ahsan.b_tendance;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Screen2 extends Activity {
    Button m1Button;
    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQ = 1;
    private BluetoothAdapter myBluetoothAdapter;
    TextView Name, Rollnumber,FatherName,UniversityName,DegreeProgram,EmailID,PhoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        ImageView imgView = (ImageView) findViewById(R.id.imageView2);
        Name = (TextView) findViewById(R.id.textView15);
        Rollnumber =(TextView) findViewById(R.id.textView21);
        FatherName =(TextView) findViewById(R.id.textView20);
        UniversityName =(TextView) findViewById(R.id.textView19);
        DegreeProgram=(TextView) findViewById(R.id.textView18);
        EmailID=(TextView) findViewById(R.id.textView17);
        PhoneNumber=(TextView) findViewById(R.id.textView16);
        myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        try
        {
            File root = new File(Environment.getExternalStorageDirectory(), "File");
            File gpxfile = new File(root, "Test.txt");
            FileInputStream fin = new FileInputStream(gpxfile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fin));
            String line;
            line = myReader.readLine();
            imgView.setImageBitmap(BitmapFactory.decodeFile(line));
            line = myReader.readLine();
            Name.setText(line);
            line = myReader.readLine();
            Rollnumber.setText(line);
            line = myReader.readLine();
            FatherName.setText(line);
            line = myReader.readLine();
            UniversityName.setText(line);
            line = myReader.readLine();
            DegreeProgram.setText(line);
            line = myReader.readLine();
            EmailID.setText(line);
            line = myReader.readLine();
            PhoneNumber.setText(line);
        }
        catch (IOException e)
        {

        }
        m1Button = (Button) findViewById(R.id.button2);
        m1Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!myBluetoothAdapter.isEnabled()) {
                    Intent turnOnIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(turnOnIntent, REQUEST_ENABLE_BT);

                    Toast.makeText(getApplicationContext(), "Bluetooth turned on",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Bluetooth is already on",
                            Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                i.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                startActivityForResult(i, REQ);

            }
});
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
        finish();
    }
}