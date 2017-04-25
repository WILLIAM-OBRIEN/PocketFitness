package com.example.williamobrien.pocketfitness;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AppCompatPopupWindow;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PedometreActivity extends ActionBarActivity implements SensorEventListener {

    SensorManager sensorManager;
    TextView steps;
    boolean running = false;
    Button butRes;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedometre);

        steps = (TextView) findViewById(R.id.steps);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        butRes = (Button)findViewById(R.id.resBtn);
        butRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num=0;
                steps.setText(String.valueOf(num));
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor!=null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        }
        else
        {
            Toast.makeText(this,"Sensor not found!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        running = false;
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(running)
        {
            steps.setText(String.valueOf(++num));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

