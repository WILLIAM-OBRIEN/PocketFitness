package com.example.williamobrien.pocketfitness;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class CalorieResults extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_results);

        String getName = getIntent().getStringExtra("Key");
        String getAge = getIntent().getStringExtra("keyAge");
        String getWeight = getIntent().getStringExtra("keyWeight");
        String getHeight = getIntent().getStringExtra("keyHeight");
        String getEx = getIntent().getStringExtra("keySpin");
        int ageNum=Integer.parseInt(getAge);
        int weightNum=Integer.parseInt(getWeight);
        int heightNum=Integer.parseInt(getHeight);
        float exMult=Float.parseFloat(getEx);

        TextView textView = (TextView) findViewById(R.id.nameBox);
        textView.setText(String.valueOf(getName));

        float total = (66+(14*weightNum)+(5*(heightNum*2))-(7*ageNum));
        total = total * exMult;

        TextView textView2 = (TextView) findViewById(R.id.caloriesTotal);
        textView.setText(String.valueOf(total));
        //Toast.makeText(getBaseContext(),getHeight,Toast.LENGTH_LONG).show();
    }
}
