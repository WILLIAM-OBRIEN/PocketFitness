package com.example.williamobrien.pocketfitness;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Home on 21/04/2017.
 */

public class Display extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.TextView);
        textView.setText(message);
    }
}
