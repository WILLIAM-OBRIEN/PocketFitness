package com.example.williamobrien.pocketfitness;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CalorieCount extends ActionBarActivity {

    Spinner calTrack;
    ArrayAdapter<CharSequence> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_count);

            calTrack = (Spinner) findViewById(R.id.AddOrSubtract);
            arrayAdapter = ArrayAdapter.createFromResource(this,R.array.calorie,android.R.layout.simple_spinner_item);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            calTrack.setAdapter(arrayAdapter);
            calTrack.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });


        String word=calTrack.getSelectedItem().toString();
        //checks if user wants to add or subtract
        if(word.equals("Add"))
        {

        }
        else if(word.equals("Subtract"))
        {
            
        }
    }
}
