package com.carParking;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String> {
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx=ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String register_url="https://automaticcarparking.000webhostapp.com/insert.php";
        String method=params[0];
        String status_url="https://automaticcarparking.000webhostapp.com/appstatus.php";
        String signup_url="https://automaticcarparking.000webhostapp.com/signup.php";
        String login_url="https://automaticcarparking.000webhostapp.com/login.php";
        String transaction_url="https://automaticcarparking.000webhostapp.com/transaction.php";
        String space_url="https://automaticcarparking.000webhostapp.com/space.php";
        String allot_url="https://automaticcarparking.000webhostapp.com/allot.php";
        String clearspace_url="https://automaticcarparking.000webhostapp.com/clearspace.php";
        if(method.equals("register"))
        {
            String id=params[1];
            String name=params[2];
            String mail=params[3];
            String contact=params[4];
            try {
                URL url=new URL(register_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("e_id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+
                            URLEncoder.encode("e_name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                            URLEncoder.encode("e_mail","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&"+
                        URLEncoder.encode("e_contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                inputStream.close();
                return response;

//                inputStream.close();
                //return "Registration Success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(method.equals("appstatus"))
        {
            //Toast.makeText(ctx,"Done",Toast.LENGTH_SHORT).show();
            String otp="95412";
            try {
                URL url=new URL(status_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("otp","UTF-8")+"="+URLEncoder.encode(otp,"UTF-8");
//                        URLEncoder.encode("e_name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
//                        URLEncoder.encode("e_mail","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&"+
//                        URLEncoder.encode("e_contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                inputStream.close();
                return response;

//                inputStream.close();
                //return "Registration Success";
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        if(method.equals("signup"))
        {
            String id=params[1];
            String name=params[2];
            String password=params[3];
            String mail=params[4];
            String contact=params[5];
            String carnumber=params[6];
            try {
                URL url=new URL(signup_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("e_id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+
                        URLEncoder.encode("e_name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("e_password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("e_mail","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&"+
                        URLEncoder.encode("e_contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8")+"&"+
                        URLEncoder.encode("e_carnumber","UTF-8")+"="+URLEncoder.encode(carnumber,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                inputStream.close();
                return response;

//                inputStream.close();
                //return "Registration Success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(method.equals("login"))
        {
            String id=params[1];
            String password=params[2];
            try {
                URL url=new URL(login_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("e_id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+
                        URLEncoder.encode("e_password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
//                        URLEncoder.encode("e_name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
//                        URLEncoder.encode("e_mail","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&"+
//                        URLEncoder.encode("e_contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                    //response+="p";
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                inputStream.close();
                return response;

//                inputStream.close();
                //return "Registration Success";
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        if(method.equals("transaction"))
        {
            String id=params[1];
            String carno=params[2];
            String entry=params[3];
            String space=params[4];
            String exit=params[5];
            String charges=params[6];
            try {
                URL url=new URL(transaction_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("e_id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8")+"&"+
                        URLEncoder.encode("e_car","UTF-8")+"="+URLEncoder.encode(carno,"UTF-8")+"&"+
                        URLEncoder.encode("e_entry","UTF-8")+"="+URLEncoder.encode(entry,"UTF-8")+"&"+
                        URLEncoder.encode("e_space","UTF-8")+"="+URLEncoder.encode(space,"UTF-8")+"&"+
                        URLEncoder.encode("e_exit","UTF-8")+"="+URLEncoder.encode(exit,"UTF-8")+"&"+
                        URLEncoder.encode("e_charges","UTF-8")+"="+URLEncoder.encode(charges,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                inputStream.close();
                return response;

//                inputStream.close();
                //return "Registration Success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(method.equals("space"))
        {
            String otp="95412";
            try {
                URL url=new URL(space_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("otp","UTF-8")+"="+URLEncoder.encode(otp,"UTF-8");
//                        URLEncoder.encode("e_name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
//                        URLEncoder.encode("e_mail","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&"+
//                        URLEncoder.encode("e_contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                inputStream.close();
                return response;

//                inputStream.close();
                //return "Registration Success";
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        if(method.equals("allot"))
        {
            String space=params[1];
            String uid=params[2];
            String entry=params[3];;
            try {
                URL url=new URL(allot_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("e_space","UTF-8")+"="+URLEncoder.encode(space,"UTF-8")+"&"+
                        URLEncoder.encode("e_id","UTF-8")+"="+URLEncoder.encode(uid,"UTF-8")+"&"+
                        URLEncoder.encode("e_entry","UTF-8")+"="+URLEncoder.encode(entry,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                inputStream.close();
                return response;

//                inputStream.close();
                //return "Registration Success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(method.equals("clearspace"))
        {
            String space=params[1];
            try {
                URL url=new URL(clearspace_url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);

                httpURLConnection.setDoInput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data=URLEncoder.encode("e_space","UTF-8")+"="+URLEncoder.encode(space,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream=httpURLConnection.getInputStream();

                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String response="";
                String line="";
                while((line=bufferedReader.readLine())!=null)
                {
                    response+=line;
                }
                bufferedReader.close();
                httpURLConnection.disconnect();
                inputStream.close();
                return response;

//                inputStream.close();
                //return "Registration Success";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "null1";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();
    }
}
