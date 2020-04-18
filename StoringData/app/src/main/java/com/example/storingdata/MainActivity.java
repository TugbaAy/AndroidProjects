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
    Button delete;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        age = findViewById(R.id.age);
        result = findViewById(R.id.result);
        save = findViewById(R.id.enter);
        delete = findViewById(R.id.delete);

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

        sharedPreferences = this.getSharedPreferences("com.example.storingdata", Context.MODE_PRIVATE);
        final int storedAge = sharedPreferences.getInt("storedAge",0); // eğer ki storedAge key'li kaydedilmiş bir değer bulunamazsa default olarak 2.parametredeki değer yazılır.
        result.setText("Your Age :" + storedAge);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(age.getText().toString().isEmpty() || age.getText().toString().matches("")){
                    result.setText("Error");
                }else{
                    String va = age.getText().toString();
                    int enteredValue = Integer.parseInt(age.getText().toString());
                    result.setText(String.valueOf(enteredValue));

                    sharedPreferences.edit().putInt("storedAge",enteredValue).apply();
                    // edit() -> sharedPreferences'i düzenlemeyi sağlar.
                    // put...() -> sharedPreferences'in içerisine değer eklemeyi sağlar.
                    // apply() -> kaydetmeyi sağlar.

                    // application silinene kadar değer orada saklı kalır.

                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int storedData = sharedPreferences.getInt("storedAge",0);
                if(storedData != 0){
                    sharedPreferences.edit().remove("storedAge").apply();
                    result.setText("Your Age:");
                }
            }
        });

    }




}
