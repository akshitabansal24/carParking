package com.example.carParking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.carParking.R;

public class Payment extends AppCompatActivity {

    String charges;
    TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        charges=getIntent().getExtras().getString("charges");
        textView4=findViewById(R.id.textView4);
        textView4.setText(charges);
    }
}
