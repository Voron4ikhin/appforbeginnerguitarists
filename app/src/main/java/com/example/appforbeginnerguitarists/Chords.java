package com.example.appforbeginnerguitarists;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Chords extends AppCompatActivity {

    Spinner sp1;
    CustomAdapter adapter;
    String[] names = {"Аm (Ля минор)", "A (Ля мажор)", "Bm (Си минор)", "B (Си мажор)", "Cm (До минор)", "C (До мажор)", "Dm (Рэ минор)", "D (Рэ мажор)", "Em (Ми минор)", "E (Ми мажор)", "Fm (Фа минор)", "F (Фа мажор)", "Gm (Соль минор)", "G (Соль мажор)"};
    int[] images = {R.drawable.chord_am, R.drawable.chord_a, R.drawable.chord_bm, R.drawable.chord_b, R.drawable.chord_cm, R.drawable.chord_c, R.drawable.chord_dm, R.drawable.chord_d, R.drawable.chord_em, R.drawable.chord_e, R.drawable.chord_fm, R.drawable.chord_f, R.drawable.chord_gm, R.drawable.chord_g};
    int chosen_chord;
    TextView t1, t2, t3;
    String stream = "Строка с музыкой";
    MediaPlayer player;
    ImageButton imageButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chords_layout);


        sp1 = (Spinner)findViewById(R.id.chord_spinner);
        adapter = new CustomAdapter(this, names, images);




        sp1.setAdapter(adapter);
        sp1.setOnTouchListener(spinnerOnTouch);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                chosen_chord = i;
                Toast.makeText(getApplicationContext(), names[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //без верхней вкладки

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Chords.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
    }

    private View.OnTouchListener spinnerOnTouch = new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                t1 = (TextView) findViewById(R.id.text_view_chord);
                t2 = (TextView) findViewById(R.id.stat_info_chord);
                t3 = (TextView) findViewById(R.id.main_info_chord);
                t1.setTextColor(Color.parseColor("#07000000"));
                t2.setTextColor(Color.parseColor("#07000000"));
                t3.setTextColor(Color.parseColor("#07000000"));

                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    };

    public void play(View v) {
        if(player == null){
            imageButton = (ImageButton) findViewById(R.id.image_play);
            imageButton.setImageResource(R.drawable.pause_button);
            if(chosen_chord == 0)
                player = MediaPlayer.create(this, R.raw.voice_am);
            if(chosen_chord == 1)
                player = MediaPlayer.create(this, R.raw.voice_a);
            if(chosen_chord == 2)
                player = MediaPlayer.create(this, R.raw.voice_hm);
            if(chosen_chord == 3)
                player = MediaPlayer.create(this, R.raw.voice_h);
            if(chosen_chord == 4)
                player = MediaPlayer.create(this, R.raw.voice_cm);
            if(chosen_chord == 5)
                player = MediaPlayer.create(this, R.raw.voice_c);
            if(chosen_chord == 6)
                player = MediaPlayer.create(this, R.raw.voice_dm);
            if(chosen_chord == 7)
                player = MediaPlayer.create(this, R.raw.voice_d);
            if(chosen_chord == 8)
                player = MediaPlayer.create(this, R.raw.voice_em);
            if(chosen_chord == 9)
                player = MediaPlayer.create(this, R.raw.voice_e);
            if(chosen_chord == 10)
                player = MediaPlayer.create(this, R.raw.voice_fm);
            if(chosen_chord == 11)
                player = MediaPlayer.create(this, R.raw.voice_f);
            if(chosen_chord == 12)
                player = MediaPlayer.create(this, R.raw.voice_gm);
            if(chosen_chord == 13)
                player = MediaPlayer.create(this, R.raw.voice_g);
            if(chosen_chord == 14)
                player = MediaPlayer.create(this, R.raw.voice_hm);
            if(chosen_chord == 15)
                player = MediaPlayer.create(this, R.raw.voice_h);

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    private void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
            imageButton = (ImageButton) findViewById(R.id.image_play);
            imageButton.setImageResource(R.drawable.play_button);
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }


    //Системная кнопка "назад"
    @Override
    public void onBackPressed () {
        try {
            Intent intent = new Intent(Chords.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }
    }
}
