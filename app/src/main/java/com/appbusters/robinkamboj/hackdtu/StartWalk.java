package com.appbusters.robinkamboj.hackdtu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StartWalk extends AppCompatActivity {
TextView start,end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_walk);
        start=(TextView)findViewById(R.id.starting_point);
        end=(TextView)findViewById(R.id.destination_point);

    }
}
