package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SelectCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cards);
        Intent i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView t = findViewById(R.id.cekilecek);
        t.setText(s);
    }
}
