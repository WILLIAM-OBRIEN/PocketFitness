package com.example.williamobrien.pocketfitness;

import android.graphics.Color;
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
        double exMult=Double.parseDouble(getEx);
        String word;

        TextView textView = (TextView) findViewById(R.id.nameBox);
        textView.setText(String.valueOf(getName));

        //double total = (66.5+(13.75*weightNum)+(5*(heightNum*2.54))-(6.75*ageNum));
        double total = ((10*weightNum)+(6.25*(heightNum))-(5*ageNum)+5);//mifflin st jeor algorithm  = 10 * weight(kg) + 6.25 * height(cm) - 5 * age(y) + 5
        total = total * exMult;

        TextView textView2 = (TextView) findViewById(R.id.caloriesTotal);
        //changes calories results colors depending on size
        /*if(total>2000 && total<2500){textView2.setTextColor(Color.YELLOW);}
        else if(total>2500&&total<3000){textView2.setTextColor(Color.parseColor("#FFA500"));}
        else if(total>3000){textView2.setTextColor(Color.parseColor("#FF4500"));}
        else{textView2.setTextColor(Color.parseColor("#00FF00"));}*/
        textView2.setText( String.format( "%.0f", total));

        TextView ggView = (TextView) findViewById(R.id.ggpounds);
        TextView gView = (TextView) findViewById(R.id.gpounds);
        TextView avgView = (TextView) findViewById(R.id.keep);
        TextView lView = (TextView) findViewById(R.id.lpounds);
        TextView llView = (TextView) findViewById(R.id.llpounds);
        word = String.format( "%.0f", total+1000);
        ggView.setText(String.valueOf(word+"kcals"));
        word = String.format( "%.0f", total+500);
        gView.setText(String.valueOf(word+"kcals"));
        word = String.format( "%.0f", total);
        avgView.setText(String.valueOf(word+"kcals"));
        word = String.format( "%.0f", total-500);
        lView.setText(String.valueOf(word+"kcals"));
        word = String.format( "%.0f", total-1000);
        llView.setText(String.valueOf(word+"kcals"));
        //textView2.setText(String.valueOf(total));
        //Toast.makeText(getBaseContext(),getHeight,Toast.LENGTH_LONG).show();
    }
}
