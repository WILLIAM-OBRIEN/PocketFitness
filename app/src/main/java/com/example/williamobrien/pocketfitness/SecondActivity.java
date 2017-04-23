package com.example.williamobrien.pocketfitness;

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
        weight_val = (EditText)findViewById(R.id.weight);
        submitCal = (Button)findViewById(R.id.cal_sub);
        submitCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = name_val.getText().toString();
                Integer getAge= age_val.getInputType();
                Integer getWeight= weight_val.getInputType();

                if (getName==null || getName.trim().equals(""))
                {
                    Toast.makeText(getBaseContext(),"No name!",Toast.LENGTH_LONG).show();
                }
                else if(getAge<=1 || getAge>=120)
                {
                    Toast.makeText(getBaseContext(),"Enter an age from 1-120!",Toast.LENGTH_LONG).show();
                }
                else if(getWeight<=10 ||  getWeight>=300)
                {
                    Toast.makeText(getBaseContext(),"Enter a weight from 10kg-300kg!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    add_cal.add(getName);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(SecondActivity.this,android.R.layout.simple_list_item_1,add_cal);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.name)).setText(" ");
                }
            }
        });
    }
}
