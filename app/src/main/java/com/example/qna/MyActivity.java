package com.example.qna;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MyActivity extends AppCompatActivity {

    private List<String> items= Arrays.asList("종이", "플라스틱", "유리", "유리조각", "비닐");


    private DrawerLayout drawerLayout;
    private View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        drawerLayout=(DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View)findViewById(R.id.drawer);

        Button btn_open = (Button)findViewById(R.id.btn_open);
            btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_home=(Button)findViewById(R.id.btn_home);
            btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //drawerLayout.closeDrawers();
                Intent intent = new Intent(MyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

            Button btn_first = (Button)findViewById(R.id.btn_first);
            btn_first.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyActivity.this,CategoryActivity.class);
                    startActivity(intent);
                }
            });

            Button btn_second = (Button)findViewById(R.id.btn_second);
            btn_second.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyActivity.this,ListActivity.class);
                    startActivity(intent);
                }
            });

            Button btn_third = (Button)findViewById(R.id.btn_third);
            btn_third.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MyActivity.this, MyActivity.class);
                    startActivity(intent);
                }
            });

        Button btn_close = (Button)findViewById(R.id.btn_close);
            btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        Button btn_bookmark = (Button)findViewById(R.id.btn_bookmark);
        btn_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this, BookmarkActivity.class);
                startActivity(intent);
            }
        });

        Button btn_mywriting = (Button)findViewById(R.id.btn_mywriting);
        btn_mywriting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this, MywritingActivity.class);
                startActivity(intent);
            }
        });

            drawerLayout.setDrawerListener(listener);
            drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        //SearchView searchView = findViewById(R.id.search_view);
        // TextView resultTextView = findViewById(R.id.textView);
            /*resultTextView.setText(getResult());
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) { // 바로바로 변함
                    resultTextView.setText(search(newText));
                    return true;
                }
            });*/
}

    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        public void onDrawerStateChanged(int newState) {

        }
    };

    private String search(String query){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<items.size(); i++){
            String item = items.get(i);
            if(item.toLowerCase().trim().contains(query)){
                sb.append(item);
                if(i!=items.size()-1){
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    private String getResult(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<items.size(); i++){
            String item = items.get(i);
            sb.append(item);
            if(i!=items.size()-1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}