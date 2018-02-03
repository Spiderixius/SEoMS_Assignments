package com.admur13.spider.assignment_1_admur13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void accelerometer(View view) {
        Intent intent = new Intent(this, Accelerometer.class);
        startActivity(intent);
    }

    public void compass(View view) {
        Intent intent = new Intent(this, Compass.class);
        startActivity(intent);
    }

    public void listOfSensors(View view) {
        Intent intent = new Intent(this, ListOfSensors.class);
        startActivity(intent);
    }

    public void locationTracker(View view) {
        Intent intent = new Intent(this, RetrieveCurrentLocation.class);
        startActivity(intent);
    }


}
