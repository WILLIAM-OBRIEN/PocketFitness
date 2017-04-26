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

        Random r = new Random();
        int pick = r.nextInt(4)+1;
        TextView tipsView = (TextView)findViewById(R.id.tipsBMI);
        TextView tipsDisplay = (TextView)findViewById(R.id.tipDisplay);


        if (pick == 1)
        {
            tipsView.setText(String.valueOf("Tip #"+pick));
            tipsDisplay.setText(String.valueOf("To lose weight rapidly try moving your chin to your left shoulder then your right. Repeat this when offered seconds."));
        }
        if (pick == 2)
        {
            tipsView.setText(String.valueOf("Tip #"+pick));
            tipsDisplay.setText(String.valueOf("Keeping a schedule of your meals helps prevent impulse eating and watching your calorie intake."));
        }
        if (pick == 3)
        {
            tipsView.setText(String.valueOf("Tip #"+pick));
            tipsDisplay.setText(String.valueOf("Eating fibrous foods, such as lean proteins, fruits and vegetables can be a good way to fill you up without being loaded with fats or sugars."));
        }
        if (pick == 4)
        {
            tipsView.setText(String.valueOf("Tip #"+pick));
            tipsDisplay.setText(String.valueOf("DRINK WATER. Water facilitates all reactions in your body and you will feel alot less tired and will find it easier to have smaller meals."));
        }
        if (pick == 5)
        {
            tipsView.setText(String.valueOf("Tip #"+pick));
            tipsDisplay.setText(String.valueOf("."));
        }
    }
}
