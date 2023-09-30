package com.carParking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nishant.androidqrcodescanner.R;

public class SignupActivity extends AppCompatActivity {

    TextView systemgeneratedid;
    EditText name,password,email,phone,carnumber;
    Button signupbutton;
    int id=(int)(1000000*Math.random());
    String n,p,e,ph,car,sysid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        carnumber=findViewById(R.id.carnumber);
        signupbutton=findViewById(R.id.signupbutton);
        name.requestFocus();
        systemgeneratedid=findViewById(R.id.systemgeneratedid);
        systemgeneratedid.setText(id+"");
        final BackgroundTask bt=new BackgroundTask(SignupActivity.this);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=name.getText().toString();
                p=password.getText().toString();
                e=email.getText().toString();
                ph=phone.getText().toString();
                car=carnumber.getText().toString();
                sysid=id+"";
                bt.execute("signup",sysid,n,p,e,ph,car);
                SignupActivity.this.finish();
            }
        });
    }
}
