package com.example.appforbeginnerguitarists;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Subjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_layout);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Subjects.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageButton button_hands = (ImageButton)findViewById(R.id.hands);
        button_hands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Subjects.this, Hands.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageButton button_guitar = (ImageButton)findViewById(R.id.about_guitar);
        button_guitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Subjects.this, Guitar_info .class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });



        ImageButton button_chords1 = (ImageButton)findViewById(R.id.chords);
        button_chords1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Subjects.this,  Chords1.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageButton button_chords2 = (ImageButton)findViewById(R.id.chords2);
        button_chords2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Subjects.this,  Chords2.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageButton button_beats= (ImageButton)findViewById(R.id.beats);
        button_beats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Subjects.this,  Beats.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

        ImageButton button_bust = (ImageButton)findViewById(R.id.bust);
        button_bust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Subjects.this,  Bust.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });




    }
    //Системная кнопка "назад"
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(Subjects.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
}