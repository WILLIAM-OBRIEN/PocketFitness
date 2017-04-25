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
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends ActionBarActivity {

    public static double exSpin=1.2;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Button submitCal;
    ArrayList<String> add_cal = new ArrayList<String>();
    EditText name_val;
    EditText age_val;
    EditText weight_val;
    EditText height_val;
    ListView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.exercise,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        name_val = (EditText)findViewById(R.id.name);
        age_val = (EditText)findViewById(R.id.age);
        age_val.setFilters(new Check_Range[]{ new Check_Range("1", "120")});
        weight_val = (EditText)findViewById(R.id.weight);
        weight_val.setFilters(new Check_Range[]{ new Check_Range("1", "300")});
        height_val = (EditText)findViewById(R.id.height);
        height_val.setFilters(new Check_Range[]{ new Check_Range("1", "300")});
        submitCal = (Button)findViewById(R.id.cal_sub);
        submitCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weightKg;
                int heightCm;
                String getName = name_val.getText().toString();
                String getAge = age_val.getText().toString();
                String getWeight = weight_val.getText().toString();
                String getHeight = height_val.getText().toString();

                if (TextUtils.isEmpty(getName)) {
                    name_val.setError("Please enter your name");
                    name_val.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(getAge))
                {
                    age_val.setError("Please enter your age");
                    age_val.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(getWeight))
                {
                    weight_val.setError("Please enter your weight");
                    weight_val.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(getHeight))
                {
                    height_val.setError("Please enter your height");
                    height_val.requestFocus();
                    return;
                }

                weightKg = Integer.parseInt(getWeight);
                heightCm = Integer.parseInt(getHeight);

                if (weightKg > 300 || weightKg < 30)
                {
                    weight_val.setError("You either need serious help or entered the wrong weight.");
                    weight_val.requestFocus();
                    return;
                }

                if (heightCm > 300 || heightCm < 60)
                {
                    height_val.setError("If you are really this height apply for the world records. Otherwise you have made an error.");
                    height_val.requestFocus();
                    return;
                }

                String word=spinner.getSelectedItem().toString();
                //calculates spinner multiplier
                if(word.equals("Light: 1 or 2 times a week")){exSpin=1.35;}
                else if(word.equals("Medium: 3 or 4 times a week")){exSpin=1.5;}
                else if(word.equals("Intense: 5 times or over a week")){exSpin=1.7;}
                else{exSpin=1.2;}
                String spinMultiplyer = Double.toString(exSpin);
                //starts new intent for calorie results activity
                Intent j = new Intent(SecondActivity.this, CalorieResults.class);
                j.putExtra("Key",getName);
                j.putExtra("keyAge",getAge);
                j.putExtra("keyWeight",getWeight);
                j.putExtra("keyHeight",getHeight);
                j.putExtra("keySpin",spinMultiplyer);
                startActivity(j);
            }
        });
    }
}
