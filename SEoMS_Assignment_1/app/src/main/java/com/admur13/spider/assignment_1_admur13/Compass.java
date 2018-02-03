package com.admur13.spider.assignment_1_admur13;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Compass extends Activity implements SensorEventListener{

    private SensorManager sensorManager;
    TextView degreeHeading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);

        degreeHeading = findViewById(R.id.textView_compassHeading);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int degree = (int)sensorEvent.values[0];
        degreeHeading.setText("Heading \n    " + Integer.toString(degree) + "°");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
