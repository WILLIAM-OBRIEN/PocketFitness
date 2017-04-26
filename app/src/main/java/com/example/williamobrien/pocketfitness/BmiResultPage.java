package com.example.williamobrien.pocketfitness;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

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
        TextView ResultSuggestion = (TextView)findViewById(R.id.suggestBox);
        usersName.setText(String.valueOf(username));

        //bmiResult.setText(String.valueOf(bmiCalc + "-" + determinedResponse));
        bmiResult.setText(String.valueOf("BMI: " + bmiCalc));
        ResultSuggestion.setText(String.valueOf(determinedResponse));

        float bmiSeekBar= Float.parseFloat(bmiCalc);

        int blah = (int)bmiSeekBar;

        SeekBar bmiSeek=(SeekBar) findViewById(R.id.SeekBarBMI);

        bmiSeek.setMax(50);

        bmiSeek.setProgress(blah);

        /*Random r = new Random();
        int pick = r.nextInt(1-2)+1;
        TextView tipsView = (TextView)findViewById(R.id.tipsBMI);
        TextView tipsDisplay = (TextView)findViewById(R.id.tipDisplay);

        if (pick == 1)
        {
            tipsDisplay.setText(String.valueOf("Tip #"+pick));
            tipsView.setText(String.valueOf("To lose weight rapidly try moving your chin to your left shoulder then your right. Repeat this when offered seconds."));
        }*/
    }
}
