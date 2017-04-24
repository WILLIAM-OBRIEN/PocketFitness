package com.example.williamobrien.pocketfitness;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.text.TextUtils;


public class MainActivity extends ActionBarActivity {

    public Button but1;
    //Takes user to BMI calculation page when pressed
    public Button but2;
    //BMI calculator input button
    public Button but3;

    //The three inputted values in BMI calc
    EditText name = (EditText) findViewById(R.id.NameInput);
    EditText weight = (EditText) findViewById(R.id.WeightInput);
    TextView height = (TextView) findViewById(R.id.HeightInput);

    public void init()
    {
        but1 = (Button)findViewById(R.id.btnShowMsg);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

        but2 = (Button)findViewById(R.id.ToBmi);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this, BMI_Calculator.class);
                startActivity(j);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Calculating bmi and returning text based on the value calculated
    public void bmiErrorCheck()
    {
        but3 = (Button) findViewById(R.id.BMIButton);

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Float variables for taking in the values of user height and weight
                float weightKg;
                float heightCm;
                float bmiCalculated;

                //Putting user inputted information into strings
                String username = name.getText().toString();
                String userWeight = weight.getText().toString();
                String userHeight = height.getText().toString();

                //Error checking input in BMI page to make sure there is input
                //There will be a message sent to the box if empty
                if (TextUtils.isEmpty(username))
                {
                    name.setError("Please enter your name");
                    name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(userWeight))
                {
                    weight.setError("Please enter your weight");
                    weight.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(userHeight))
                {
                    height.setError("Please enter your height");
                    height.requestFocus();
                    return;
                }

                //Parsing inputted values in height and weight
                weightKg = Float.parseFloat(userWeight);
                heightCm = Float.parseFloat(userHeight);

                //Reference to method CalculateBmi function
                bmiCalculated = calculateBmi(weightKg, heightCm);

                String determineResponse = interpretBmi(bmiCalculated);
            }

        });
    }


    //Calculating bmi
    private Float calculateBmi(float kg, float cm)
    {
        float toBeReturned = 0.0f;
        float heightCalculate = 0.0f;

        toBeReturned = toBeReturned + (kg * .45f);

        heightCalculate = heightCalculate + (cm * .025f);

        heightCalculate = heightCalculate * heightCalculate;

        toBeReturned = toBeReturned / heightCalculate;

        return(toBeReturned);
    }


    private String interpretBmi(float bmiCalculated)
    {
        if (bmi)
    }
}
