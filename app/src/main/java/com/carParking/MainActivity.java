package com.carParking;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nishant.androidqrcodescanner.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

//implementing onclicklistener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //View Objects
    private Button buttonScan;
    private TextView textViewName, textViewAddress;

    //qr code scanner object
    private IntentIntegrator qrScan;
    String uid="";
    String carno="";
    String entry="",exit="",space="",charges="";
    String[] info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uid=getIntent().getExtras().getString("uid");
        carno=getIntent().getExtras().getString("carno");
        //Toast.makeText(MainActivity.this,"user id is "+uid,Toast.LENGTH_SHORT).show();
        //View objects
        buttonScan = (Button) findViewById(R.id.button1);
//        textViewName = (TextView) findViewById(R.id.textView);
//        textViewAddress = (TextView) findViewById(R.id.textView2);

        //intializing scan object
        qrScan = new IntentIntegrator(this);

        //attaching onclick listener
        buttonScan.setOnClickListener(this);
    }

    //Getting the scan results
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();

                //String method="appstatus";
                String otp=result.getContents();
                BackgroundTask bt1=new BackgroundTask(MainActivity.this);
                BackgroundTask bt2=new BackgroundTask(MainActivity.this);
                BackgroundTask bt3=new BackgroundTask(MainActivity.this);
                BackgroundTask bt4=new BackgroundTask(MainActivity.this);
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                entry=sdf.format(date);
                //entry=date.toString();
                exit=sdf.format(date);
                space="space";
                charges="150";
                String res="";
                try {
                    if((res=bt1.execute("transaction",uid,carno,entry,space,exit,charges).get()).contains("Entry success"))
                    {
                        info=bt3.execute("space").get().toString().split(";");
                        bt4.execute("allot",info[0],uid,entry);
                        Toast.makeText(MainActivity.this,"You have been alloted: "+info[0],Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?daddr="+info[1]+","+info[2]));
                startActivity(intent);

                    }
                    else if(res.contains("Exit success"))
                    {
                        BackgroundTask bt5=new BackgroundTask(MainActivity.this);
                        bt5.execute("clearspace",info[0]);
                        Intent payment=new Intent(MainActivity.this,Payment.class);
                        payment.putExtra("charges",res.replace("Exit success",""));
                        startActivity(payment);
                        Toast.makeText(MainActivity.this,"Charges: "+res.replace("Exit success",""),Toast.LENGTH_SHORT).show();
                    }
                    bt2.execute("appstatus");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                //if qr contains data
//                try {
//                    //converting the data to json
//                    JSONObject obj = new JSONObject(result.getContents());
//                    //setting values to textviews
//                    textViewName.setText(obj.getString("name"));
//                    textViewAddress.setText(obj.getString("address"));
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    //if control comes here
//                    //that means the encoded format not matches
//                    //in this case you can display whatever data is available on the qrcode
//                    //to a toast
//                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
//                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    @Override
    public void onClick(View view) {
        //initiating the qr code scan
        qrScan.initiateScan();
    }
}