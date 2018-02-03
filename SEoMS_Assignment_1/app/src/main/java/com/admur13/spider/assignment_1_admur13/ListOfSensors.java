package com.admur13.spider.assignment_1_admur13;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class ListOfSensors extends Activity {

    private TextView textview_listOfSensors = null;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_sensors);

        textview_listOfSensors = (TextView) findViewById(R.id.textView_listOfSensors);
        textview_listOfSensors.setMovementMethod(new ScrollingMovementMethod());
        textview_listOfSensors.setVisibility(View.GONE);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (int i = 1; i < sensorList.size(); i++) {
            textview_listOfSensors.setVisibility(View.VISIBLE);
            textview_listOfSensors.append("\n" + sensorList.get(i).getName()
                    + "\n" + sensorList.get(i).getVendor() + "\n");
        }
    }


}
