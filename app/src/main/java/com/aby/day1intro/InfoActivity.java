package com.aby.day1intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        txtView = findViewById(R.id.txtInfo);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("Name");
            txtView.setText("Welcome " + value);
            txtView.setTextColor(getResources().getColor(R.color.errorColor));
            txtView.setTextSize(24);
        }
    }
}
