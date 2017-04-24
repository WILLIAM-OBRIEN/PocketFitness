package com.example.williamobrien.pocketfitness;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
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
        if(spinner.getSelectedItem().toString().equals("Intense: Over 5 times a week")){exSpin=(6/5);}
        /*else if(index==1){exSpin=(3/2);}
        else if(index==2){exSpin=(17/10);}
        else if(index==3){exSpin=(19/10);}
        exSpin=(5/2);*/
        //String exercise_choice = spinner.getSelectedItem().toString();
        //spinner choice
        /*if(exercise_choice.equals("None: I am a human vegetable")){exSpin=1.2;}
        else if(exercise_choice.equals("None: I am a human vegetable")){exSpin=1.375;}
        else if(exercise_choice.equals("Light: 1\"-\"3 times a week")){exSpin=1.55;}
        else if(exercise_choice.equals("Medium: 4 or 5 times a week")){exSpin=1.725;}
        else if(exercise_choice.equals("Intense: Over 5 times a week")){exSpin=1.9;}
        else{exSpin="1.2";}*/

        name_val = (EditText)findViewById(R.id.name);
        age_val = (EditText)findViewById(R.id.age);
        age_val.setFilters(new Check_Range[]{ new Check_Range("1", "120")});
        weight_val = (EditText)findViewById(R.id.weight);
        weight_val.setFilters(new Check_Range[]{ new Check_Range("1", "300")});
        height_val = (EditText)findViewById(R.id.height);
        height_val.setFilters(new Check_Range[]{ new Check_Range("1", "100")});
        submitCal = (Button)findViewById(R.id.cal_sub);
        submitCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = name_val.getText().toString();
                String getAge = age_val.getText().toString();
                String getWeight = weight_val.getText().toString();
                String getHeight = height_val.getText().toString();

                if (getName.length()==0)
                {
                    Toast.makeText(getBaseContext(),"No name!",Toast.LENGTH_LONG).show();
                }
                else if(getAge.length()==0)
                {
                    Toast.makeText(getBaseContext(),"Enter an age!",Toast.LENGTH_LONG).show();
                }
                else if(getWeight.length()==0)
                {
                    Toast.makeText(getBaseContext(),"Enter a weight!",Toast.LENGTH_LONG).show();
                }
                else if(getHeight.length()==0)
                {
                    Toast.makeText(getBaseContext(),"Enter a height!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    String word=spinner.getSelectedItem().toString();
                    //calculates spinner multiplyer
                    if(word.equals("Light: 1 or 2 times a week")){exSpin=1.5;}
                    else if(word.equals("Medium: 3 or 4 times a week")){exSpin=1.7;}
                    else if(word.equals("Intense: 5 times or over a week")){exSpin=1.9;}
                    else{exSpin=1.2;}
                    String spinMultiplyer = Double.toString(exSpin);
                    Intent j = new Intent(SecondActivity.this, CalorieResults.class);
                    j.putExtra("Key",getName);
                    j.putExtra("keyAge",getAge);
                    j.putExtra("keyWeight",getWeight);
                    j.putExtra("keyHeight",getHeight);
                    j.putExtra("keySpin",spinMultiplyer);
                    Toast.makeText(getBaseContext(),spinMultiplyer,Toast.LENGTH_LONG).show();
                    startActivity(j);
                    //add_cal.add(getName);
                    //ArrayAdapter<String> adapter = new ArrayAdapter<String>(SecondActivity.this,android.R.layout.simple_list_item_1,add_cal);
                    //show.setAdapter(adapter);
                    //((EditText)findViewById(R.id.name)).setText(" ");
                }
            }
        });
    }
}
