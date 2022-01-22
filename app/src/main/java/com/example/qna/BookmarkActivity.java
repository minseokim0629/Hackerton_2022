package com.example.qna;

import static android.os.Environment.DIRECTORY_PICTURES;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


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


public class BookmarkActivity extends AppCompatActivity {

    private List<String> items = Arrays.asList("종이", "플라스틱", "유리", "유리조각", "비닐");
    private List<String> trash = Arrays.asList("계란껍데기","유리병","스티로폼", "장난감");
    private List<String> recycle = Arrays.asList("사료나 퇴비로 만들 수 없으므로 일반 종량제 봉투로 배출해주세요.",
            "플라스틱이나 알루미늄 뚜껑 제거 후 내용물을 깨끗이 비운 후 배출해주세요.\n깨진 유리는 신문지에 싸서 종량제 봉투에 버리고, 양이 많을 경우 특수구격마대(불연물질)를 구매하여 배출해주세요.",
            "내용물을 비우고 물로 헹구는 등 이물질을 제거하여 배출해주세요.\n음식물 등의 이물질이 묻은 경우 일반 종량제 봉투로 배출해주세요.",
            "재질별로 분리 후 재활용품으로 배출해주세요.\n재질별 분리가 어려울 경우 일반 쓰레기로 배출하시고, 대형 완구류는 대형 폐기물로 신고 후, 배출수수료를 납부하고 배출해야합니다.");


    private ArrayList<TrashList> TList;
    private MyRecyclerAdapter myRecyclerAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private DrawerLayout drawerLayout;
    private View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);

        Button btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_camera = (Button) findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookmarkActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        Button btn_first = (Button) findViewById(R.id.btn_first);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookmarkActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        Button btn_second = (Button) findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookmarkActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        Button btn_third = (Button) findViewById(R.id.btn_third);
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookmarkActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });

        Button btn_store = (Button) findViewById(R.id.btn_store);
        btn_store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookmarkActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });

        Button btn_home = (Button) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //drawerLayout.closeDrawers();
                Intent intent = new Intent(BookmarkActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btn_close = (Button) findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawers();
            }
        });

        drawerLayout.setDrawerListener(listener);
        drawerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        TList = new ArrayList<>();

        myRecyclerAdapter = new MyRecyclerAdapter(TList);
        recyclerView.setAdapter(myRecyclerAdapter);

        for(int i=0; i<=3; i++)
        {
            TList.add(new TrashList(trash.get(i),recycle.get(i)));
        }
        myRecyclerAdapter.notifyDataSetChanged();
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

    private String search(String query) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            if (item.toLowerCase().trim().contains(query)) {
                sb.append(item);
                if (i != items.size() - 1) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            sb.append(item);
            if (i != items.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}