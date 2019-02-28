package com.sivinskikh.hw_a1l1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView weatherview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherview = findViewById(R.id.testview);
        weatherview.setText(getString(R.string.weather));
    }
}
