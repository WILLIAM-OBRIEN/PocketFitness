package com.example.williamobrien.pocketfitness;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BmiResultPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result_page);


        String bmiCalc = getIntent().getStringExtra("key");
        String determinedResponse = getIntent().getStringExtra("work");
        String username = getIntent().getStringExtra("name");

        TextView usersName = (TextView)findViewById(R.id.UsersName);
        TextView bmiResult = (TextView)findViewById(R.id.BMIResult);
        usersName.setText(String.valueOf(username));

        bmiResult.setText(String.valueOf(bmiCalc + "-" + determinedResponse));
    }
}
