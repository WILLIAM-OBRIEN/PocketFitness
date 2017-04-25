package com.example.williamobrien.pocketfitness;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;



public class MainActivity extends ActionBarActivity {

    public Button but1;

    public Button but2;

    public Button but3;

    public Button but4;

    public void init()
    {
        but1 = (Button)findViewById(R.id.btnShowMsg);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });


        but2 = (Button)findViewById(R.id.ToBmi);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, BMI_Calculator.class);
                startActivity(j);
            }
        });

        but3 = (Button)findViewById(R.id.btnShowMetre);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent k = new Intent(MainActivity.this, PedometreActivity.class);
                startActivity(k);
            }
        });

        but4 = (Button)findViewById(R.id.CaloreTracker);
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent l = new Intent(MainActivity.this, CalorieCount.class);
                startActivity(l);
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

}
