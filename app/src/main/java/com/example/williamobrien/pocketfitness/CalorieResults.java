package com.example.williamobrien.pocketfitness;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

public class CalorieResults extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_results);

        String getName = getIntent().getStringExtra("keyName");
        String getAge = getIntent().getStringExtra("keyAge");
        String getWeight = getIntent().getStringExtra("keyWeight");
        String getHeight = getIntent().getStringExtra("keyHeight");
        int AgeNum=Integer.parseInt(getAge);
        int weightNum=Integer.parseInt(getWeight);
        int heightNum=Integer.parseInt(getHeight);
        Toast.makeText(getBaseContext(),getHeight,Toast.LENGTH_LONG).show();
    }
}
