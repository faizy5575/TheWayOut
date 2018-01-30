package com.exmple.taimoor.thewayout;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker(Context cxt){
        context = cxt;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://192.168.53.53:8080/theWayOut/login.php";
        String Registration_url = "http://192.168.53.53:8080/theWayOut/register.php";
                if(type.equals("login")) {
                    try {
                        String userName = params[1];
                        String password = params[2];
                        URL url = new URL(login_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);

                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("userName", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8") + "&"
                                + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;


                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                        }
           else if(type.equals("Registration")) {

                    try {
                        String name = params[1];
                        String cnic = params[2];
                        String address = params[3];
                        String password = params[4];
//                        String reenteredpassword = params[5];
                        URL url = new URL(Registration_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);

                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                                URLEncoder.encode("CNIC", "UTF-8") + "=" + URLEncoder.encode(cnic, "UTF-8") + "&" +
                                URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&" +
                                URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") ;
//                                + "&"+ URLEncoder.encode("reenteredpassword", "UTF-8") + "=" + URLEncoder.encode(reenteredpassword, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                        String result = "";
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null) {
                            result += line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;


                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }





        return "";

    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        //alertDialog.show();
        if(result.contentEquals("Login success") || result.contentEquals("Insert Successful")) {

            context.startActivity(new Intent(context, HomeActivity.class));

        }
        else

        {
            Toast.makeText(context, "Wrong Username or Password!", Toast.LENGTH_SHORT).show();
       }

    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
