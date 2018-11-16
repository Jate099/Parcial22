package com.example.quizuno.parcial2;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    int suma;
    float promedio;
    String valor;
    String total;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;

    TextView score;

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.score1);
        btn2 = findViewById(R.id.score2);
        btn3 = findViewById(R.id.score3);
        btn4 = findViewById(R.id.score4);
        btn5 = findViewById(R.id.score5);

        score = findViewById(R.id.score);

        db = FirebaseDatabase.getInstance();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getReference().child("score").child("avengers").push().setValue("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getReference().child("score").child("avengers").push().setValue("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getReference().child("score").child("avengers").push().setValue("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getReference().child("score").child("avengers").push().setValue("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.getReference().child("score").child("avengers").push().setValue("5");
            }
        });

        /*db.getReference().child("score").child("avengers").child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                votos1 = "score ("+dataSnapshot.getChildrenCount()+")";
                //score.setText(votos1);

                //clase1 = Integer.parseInt(votos1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        db.getReference().child("score").child("avengers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String votos = "score ("+dataSnapshot.getChildrenCount()+")";
                score.setText(votos);

                for(DataSnapshot esnacha : dataSnapshot.getChildren()){
                    Log.e("Clave", ""+esnacha.getKey());
                    Log.e("valor", ""+esnacha.getValue());

                    valor = esnacha.getValue(String.class);
                    Log.e("Valor trabsformado", ""+valor);
                }

                //int val = Integer.parseInt(valor);

                //suma += val;
                //float total = dataSnapshot.getChildrenCount();

                //promedio = suma/total;
                //Log.e("promedio", ""+promedio);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
