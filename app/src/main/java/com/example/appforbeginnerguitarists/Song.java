package com.example.appforbeginnerguitarists;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import javax.security.auth.Subject;

public class Song extends AppCompatActivity {

    Button buttonScrollDown;
    ScrollView myScroll;
    boolean scroll = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_layout);


        buttonScrollDown = (Button) findViewById(R.id.scroll_button);
        myScroll = (ScrollView) findViewById(R.id.my_scroll);


        buttonScrollDown.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                myScroll.scrollBy(0, +40);
            }
        });



        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Song.this, Songs.class);
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
            Intent intent = new Intent(Song.this, Songs.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
}