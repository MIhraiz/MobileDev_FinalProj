package com.example.myproj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
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

public class UpdateForm extends AppCompatActivity {
    private EditText edtUpName;
    private EditText edtUpEmail;
    private EditText edtUpPass;
    private String USER = "";
    private String[] tokens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_form);
        setupViews();

    }

    void setupViews(){
        Intent intent = getIntent();
        USER = intent.getStringExtra("USER");
        tokens = USER.split(",");
        System.out.println("***************************************************************: " + tokens[0]);
        edtUpEmail = findViewById(R.id.edtUpEmail);
        edtUpName = findViewById(R.id.edtUpName);
        edtUpPass = findViewById(R.id.edtUpPass);
        edtUpEmail.setText(tokens[0]+"");
        edtUpName.setText(tokens[1]+"");
        edtUpPass.setText(tokens[2]+"");
    }

    private String processRequest(String restUrl) throws UnsupportedEncodingException {
        String name = edtUpName.getText().toString();
        System.out.println(name);
        String email = edtUpEmail.getText().toString();
        String pass = edtUpPass.getText().toString();

        String em = tokens[0];

        String data = URLEncoder.encode("pass", "UTF-8")
                + "=" + URLEncoder.encode(pass, "UTF-8");

        data += "&" + URLEncoder.encode("email", "UTF-8") + "="
                + URLEncoder.encode(email, "UTF-8");

        data += "&" + URLEncoder.encode("name", "UTF-8")
                + "=" + URLEncoder.encode(name, "UTF-8");

        data += "&" + URLEncoder.encode("em", "UTF-8")
                + "=" + URLEncoder.encode(em, "UTF-8");


        String text = "";
        BufferedReader reader = null;

        // Send data
        try {

            // Defined URL  where to send data
            URL url = new URL(restUrl);

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the server response

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";

            // Read Server Response
            while ((line = reader.readLine()) != null) {
                // Append server response in string
                sb.append(line + "\n");
            }


            text = sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                reader.close();
            } catch (Exception ex) {
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
            Toast.makeText(UpdateForm.this, result, Toast.LENGTH_SHORT).show();
        }
    }

    public void btnOnClick_Update(View view) {
        String restUrl = "http://192.168.0.111:80/rest/update.php";
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    123);

        } else {
            UpdateForm.SendPostRequest runner = new UpdateForm.SendPostRequest();
            runner.execute(restUrl);
        }
    }
}