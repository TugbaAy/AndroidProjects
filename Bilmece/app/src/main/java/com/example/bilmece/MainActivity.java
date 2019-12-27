package com.example.bilmece;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, EditText.OnEditorActionListener {

    TextView t1;
    TextView t2;
    Button saldir;
    Button yemekYe;
    Button uyu;
    Karakter k;
    EditText isim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.attributes); // üstte default gelecek özellikler için
        t2 = findViewById(R.id.message);

        Log.d("attributes_id", t1.toString());
        Log.d("message_id", t2.toString());

        // buttonlar

        saldir = (Button) findViewById(R.id.saldir);
        yemekYe = (Button) findViewById(R.id.yemekYe);
        uyu = (Button) findViewById(R.id.uyu);

        Log.d("saldir_id", saldir.toString());
        Log.d("yemekYe_id", yemekYe.toString());
        Log.d("uyu_id", uyu.toString());

        // isim editText

        isim = findViewById(R.id.isim);

        k = new Karakter();
        k.hareketSayisi = 10;
        k.kilo = 10;
        k.saldiriGucu = 100;

        // button listenerları

        isim.setOnEditorActionListener(this);

        saldir.setOnClickListener(this);
        yemekYe.setOnClickListener(this);
        uyu.setOnClickListener(this);

        // edittext listenerı


        t1.setText(k.toString());
        t2.setText("Oyuna Hoşgeldiniz. Lütfen bir eylem seçin.");
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        t2.setText("Karakterimizin ismi : "+isim.getText() + " olarak belirlendi.");
        k.isim = isim.getText().toString();
        isim.setVisibility(View.INVISIBLE);
        t1.setText(k.toString());
        return true;
    }

    @Override
    public void onClick(View v) {
        Log.d("v.getId()", String.valueOf(v.getId()));
        if (v.getId() == saldir.getId()) {
            t2.setText(k.savas());
        } else if (v.getId() == yemekYe.getId()) {
            t2.setText(k.yemek());
        } else {
            t2.setText(k.uyu());
        }

        t1.setText(k.toString());

    }
}
