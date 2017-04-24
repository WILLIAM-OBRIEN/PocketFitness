package com.example.williamobrien.pocketfitness;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BMI_Calculator extends ActionBarActivity {

    //BMI calculator input button
    public Button but3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);


        //Calculating bmi and returning text based on the value calculated


        but3 = (Button) findViewById(R.id.BMIButton);

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Float variables for taking in the values of user height and weight
                float weightKg;
                float heightCm;
                float bmiCalculated;

                //The three inputted values in BMI calc
                EditText name = (EditText) findViewById(R.id.NameInput);
                EditText weight = (EditText) findViewById(R.id.WeightInput);
                EditText height = (EditText) findViewById(R.id.HeightInput);


                //Putting user inputted information into strings
                String username = name.getText().toString();
                String userWeight = weight.getText().toString();
                String userHeight = height.getText().toString();

                //Error checking input in BMI page to make sure there is input
                //There will be a message sent to the box if empty
                if (TextUtils.isEmpty(username)) {
                    name.setError("Please enter your name");
                    name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(userWeight)) {
                    weight.setError("Please enter your weight");
                    weight.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(userHeight)) {
                    height.setError("Please enter your height");
                    height.requestFocus();
                    return;
                }

                //Parsing inputted values in height and weight
                weightKg = Float.parseFloat(userWeight);
                heightCm = Float.parseFloat(userHeight);

                //Reference to method CalculateBmi function
                bmiCalculated = calculateBmi(weightKg, heightCm);

                String determinedResponse = interpretBmi(bmiCalculated);


                String bmiCalcString = Float.toString(bmiCalculated);
                Intent j = new Intent(BMI_Calculator.this, BmiResultPage.class);
                j.putExtra("key",bmiCalcString);
                j.putExtra("work",determinedResponse);
                j.putExtra("name", username);
                startActivity(j);

            }
        });
    }


    //Calculating bmi
    private Float calculateBmi(float kg, float cm)
    {
        float toBeReturned = kg;
        float heightCalculate = cm;

        heightCalculate = heightCalculate * heightCalculate;

        heightCalculate = heightCalculate / 100.0f;

        toBeReturned = toBeReturned / heightCalculate;

        toBeReturned = toBeReturned * 100;

        return(toBeReturned);
    }


    private String interpretBmi(float bmi)
    {
        if (bmi < 18.5f)
        {
            return("You are underweight. It is advised that you consult a doctor");
        }//end if
        else if (bmi < 25)
        {
            return("You are within normal bmi range");
        }//End else if
        else if (bmi > 25)
        {
            return("You are overweight. Consider exercising more and eating less junk food");
        }

        //If none of the above apply somehow
        return("Error");
    }
}
