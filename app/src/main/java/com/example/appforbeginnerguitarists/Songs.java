package com.example.appforbeginnerguitarists;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import javax.security.auth.Subject;

public class Songs extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs_layout);

        createExampleList();
        buildRecyclerView();



        EditText editText = findViewById(R.id.edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });





        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Songs.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

    }

    public void filter(String text){
        ArrayList<ExampleItem> filteredList = new ArrayList<>();

        for (ExampleItem item : mExampleList){
            if (item.getText1().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }
        mAdapter.filterList(filteredList);
    }

    public void createExampleList(){
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem("One", "Line 2"));
        mExampleList.add(new ExampleItem("Two", "Line 2"));
        mExampleList.add(new ExampleItem("Three", "Line 2"));
        mExampleList.add(new ExampleItem("Four", "Line 2"));
        mExampleList.add(new ExampleItem("Five", "Line 2"));
        mExampleList.add(new ExampleItem("Six", "Line 2"));
        mExampleList.add(new ExampleItem("Seven", "Line 2"));
        mExampleList.add(new ExampleItem("Макс Корж", "Line 2"));
        mExampleList.add(new ExampleItem("Нервы", "Line 2"));
        mExampleList.add(new ExampleItem("Земфира", "Line 2"));
        mExampleList.add(new ExampleItem("Тату", "Line 2"));
        mExampleList.add(new ExampleItem("Заебався", "Line 2"));
        mExampleList.add(new ExampleItem("D_mask", "Line 2"));
        mExampleList.add(new ExampleItem("Eminem", "Line 2"));
    }

    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(), "click", Toast.LENGTH_SHORT).show();
            }
        });
    }




    //Системная кнопка "назад"
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(Songs.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
}