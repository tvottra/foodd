package com.leviticus.foodd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Button button1 = (Button) findViewById(R.id.button1);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onButton1Click(View v) {
        Intent switchtofoodscan = new Intent(this, Foodpagexml.class);
        startActivity(switchtofoodscan);
    }

    public void onButton3Click(View v){
        Intent switchtoExpiryScan = new Intent(this, ExpiryScanner.class);
        startActivity(switchtoExpiryScan);
    }
}


