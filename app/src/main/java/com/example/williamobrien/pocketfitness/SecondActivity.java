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

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    Button submitCal;
    ArrayList<String> add_cal = new ArrayList<String>();
    EditText name_val;
    EditText age_val;
    EditText weight_val;
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
        weight_val.setFilters(new Check_Range[]{ new Check_Range("1", "200")});
        submitCal = (Button)findViewById(R.id.cal_sub);
        submitCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = name_val.getText().toString();
                String getAge = age_val.getText().toString();
                String getWeight = weight_val.getText().toString();

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
                else
                {
                    Intent j = new Intent(SecondActivity.this, CalorieResults.class);
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
