package com.example.appforbeginnerguitarists;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import javax.security.auth.Subject;

public class Beats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beats_layout);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Beats.this, Subjects.class);
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
            Intent intent = new Intent(Beats.this, Subjects.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
}