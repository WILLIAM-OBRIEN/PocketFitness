package com.example.williamobrien.pocketfitness;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalorieCount extends ActionBarActivity {

    Spinner calTrack;
    ArrayAdapter<CharSequence> arrayAdapter;
    public Button calorieSubmit;
    int counter = 0;
    EditText inputCalorie;
    TextView calorieCount;
    double maxCaloriesNorm;
    String input;
    String name;


    double ifTotalExist;

    String conversion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_count);


        calorieSubmit = (Button) findViewById(R.id.CalorieUpdate);
        inputCalorie = (EditText) findViewById(R.id.EnterNumber);
        calorieCount = (TextView) findViewById(R.id.CaloriesCount);
        calTrack = (Spinner) findViewById(R.id.AddOrSubtract);
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.calorie, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Set calories display to counter
        calorieCount.setText("Calories: " + counter);

        Intent checker = getIntent();
        Bundle b = checker.getExtras();






        calTrack.setAdapter(arrayAdapter);
        calTrack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        calorieSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent checker = getIntent();
                Bundle b = checker.getExtras();


                if (b != null)
                {
                    conversion = getIntent().getStringExtra("PassedRecommendedCalories");
                    ifTotalExist = Double.parseDouble(conversion);
                    name = getIntent().getStringExtra("name");
                    maxCaloriesNorm = ifTotalExist;
                }
                else
                {
                    maxCaloriesNorm = 2200;
                }


                String word = calTrack.getSelectedItem().toString();
                //checks if user wants to add or subtract


                if (word.equals("Add")) {
                    input = inputCalorie.getText().toString();

                    if (TextUtils.isEmpty(input))
                    {
                        inputCalorie.setError("Please enter calories");
                        inputCalorie.requestFocus();
                    } else
                        {
                            if (counter >= 5000)
                            {
                                counter = 5000;
                                calorieCount.setText("Calories: " + counter);
                            }
                            else
                            {
                                counter = Integer.parseInt(input) + counter;
                                calorieCount.setText("Calories: " + counter);
                            }
                        if (counter > maxCaloriesNorm)
                        {
                            if (name == null)
                            {
                                Toast.makeText(getBaseContext(), "Unknown" + " you have exceded your daily calorie intake!", Toast.LENGTH_LONG).show();

                            }
                            else
                            {
                                Toast.makeText(getBaseContext(), name + " you have exceded your daily calorie intake!", Toast.LENGTH_LONG).show();
                            }
                        }


                    }

                }


                if (word.equals("Subtract")) {

                    input = inputCalorie.getText().toString();

                    if (TextUtils.isEmpty(input)) {
                        inputCalorie.setError("Please enter calories");
                        inputCalorie.requestFocus();
                    } else
                        {
                            if (counter <= 0)
                            {
                                counter = 0;
                                calorieCount.setText("Calories: " + counter);
                            }
                            else
                            {
                                counter = counter - Integer.parseInt(input);
                                calorieCount.setText("Calories: " + counter);
                            }

                        }


                }
            }
        });
    }
}
