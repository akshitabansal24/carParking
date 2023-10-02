package com.example.carParking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carParking.BackgroundTask;
import com.example.carParking.ForgotPassword;
import com.example.carParking.MainActivity;
import com.example.carParking.SignupActivity;
import com.example.carParking.R;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    EditText loginid,password;
    Button loginbutton;
    TextView textView7,registerbutton;
    String id,pass;
    String data[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginid=findViewById(R.id.loginid);
        password=findViewById(R.id.password);
        loginbutton=findViewById(R.id.loginbutton);
        textView7=findViewById(R.id.textView7);
        registerbutton=findViewById(R.id.registerbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackgroundTask bt=new BackgroundTask(LoginActivity.this);
                id=loginid.getText().toString();
                pass=password.getText().toString();
                //complete code here.
                try {
                    data=bt.execute("login",id,pass).get().toString().split(";");
                    //Toast.makeText(LoginActivity.this,data,Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if(data[0].equals("true")) {
                    Toast.makeText(LoginActivity.this,"Welcome "+data[1],Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(LoginActivity.this, MainActivity.class);
                    in.putExtra("uid",(data[2]));
                    in.putExtra("carno",data[3]);
                    startActivity(in);
                    LoginActivity.this.finish();
                }
                else{
                    Toast.makeText(LoginActivity.this,"Login Error",Toast.LENGTH_SHORT).show();
                }
                //LoginActivity.this.finish();
            }
        });
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(in);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forgotpass=new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(forgotpass);
            }
        });
    }
}
