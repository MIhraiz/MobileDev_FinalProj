package com.example.myproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Registration extends AppCompatActivity {

    private EditText edtRegName;
    private EditText edtRegPass;
    private EditText edtRegEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edtRegName = findViewById(R.id.edtUpName);
        edtRegPass = findViewById(R.id.edtUpPass);
        edtRegEmail = findViewById(R.id.edtUpEmail);

    }


    private String processRequest(String restUrl) throws UnsupportedEncodingException {
        String name = edtRegName.getText().toString();
        System.out.println(name);
        String email = edtRegEmail.getText().toString();
        String pass = edtRegPass.getText().toString();

        String data = URLEncoder.encode("passs", "UTF-8")
                + "=" + URLEncoder.encode(pass, "UTF-8");

        data += "&" + URLEncoder.encode("email", "UTF-8") + "="
                + URLEncoder.encode(email, "UTF-8");

        data += "&" + URLEncoder.encode("myname", "UTF-8")
                + "=" + URLEncoder.encode(name, "UTF-8");

        String text = "";
        BufferedReader reader=null;

        // Send data
        try
        {

            // Defined URL  where to send data
            URL url = new URL(restUrl);

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write( data );
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {

                reader.close();
            }

            catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        // Show response on activity
        return text;



    }



    private class SendPostRequest extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            try {
                return processRequest(urls[0]);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return "";
        }
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(Registration.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    public void btnOnClick_Register(View view) {
        String restUrl = "http://192.168.0.111:80/rest/reg.php";
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    123);

        } else{
            if (!edtRegPass.getText().toString().equals("") && !edtRegName.getText().toString().equals("")){
                if(!TextUtils.isEmpty(edtRegEmail.getText().toString()) && Patterns.EMAIL_ADDRESS.matcher(edtRegEmail.getText().toString()).matches()){
                    SendPostRequest runner = new SendPostRequest();
                    runner.execute(restUrl);
                } else {
                    Toast.makeText(this,"Enter a valid Email Address",Toast.LENGTH_LONG).show();
                }

            } else {
                Toast.makeText(this,"Enter a valid Data",Toast.LENGTH_LONG).show();

            }

        }
    }
}