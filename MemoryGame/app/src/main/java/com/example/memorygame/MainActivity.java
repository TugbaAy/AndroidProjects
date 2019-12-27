package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = ((Button) findViewById(R.id.startGame));
        final EditText isim = findViewById(R.id.isim);


        // start butonuna basıldığında oyunu başlatma sayfasına geçecek.
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SelectCards.class);  // MainActivity intenti, SelectCards intentini çalıştıracak.
                String tugba = isim.getText().toString();//burada edittext teki veriyi aldım String olarak atadım
                i.putExtra("mesaj",tugba);//burada string değeri intent ile gönderme için ekledim
                startActivity(i);
            }
        });
    }
}
