package com.rafsan.class250parsingdatafmserverwithvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);

        progressBar = findViewById(R.id.progressBar);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://ali71.000webhostapp.com/apps/hello.php",

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        textView.setText("Server Response is : \n"+response);
                        progressBar.setVisibility(View.GONE);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        textView.setText("Server is not responsing");
                        progressBar.setVisibility(View.GONE);

                    }
                }

        );

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

    }
}