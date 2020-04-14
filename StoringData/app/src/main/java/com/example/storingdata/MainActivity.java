package com.example.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText age;
    TextView result;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        age = findViewById(R.id.age);
        result = findViewById(R.id.result);
        save = findViewById(R.id.enter);

        /*
        Uygulama yazarken bazı verileri uygulama kapatılsada saklamak isteriz.
        Bunun için web uygulamalarında database kullanılmaktadır.
        Android uygulamamızda da database kullanabiliriz. SQLite veri tabanı kullanarak uygulama içinde verileri saklayabiliriz.
        Ancak veritabanı kullanmak hem daha zahmetlidir hem de küçük datalar saklamak için gereksizdir.
        Bu durumlarda SharedPreferences kullanmak çok daha pratiktir.
         string,int,boolean,float,long tipinde veriler kaydedilebilir.
         */

        //this.getPreferences -> aynı aktivite içerisinde veri kaydetme/gösterme
        // this.getSharedPreferences ->kaydettiğimiz veriyi farklı bir activity’de kullanmak istediğimizde

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.storingdata", Context.MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("button click",age.getText().toString());
                if(age.getText().toString().isEmpty() || age.getText().toString().matches("")){
                    result.setText("Error");
                }else{
                    String va = age.getText().toString();
                    Log.d("else",va);
                    int enteredValue = Integer.parseInt(age.getText().toString());
                    result.setText(String.valueOf(enteredValue));
                }
            }
        });

    }




}
