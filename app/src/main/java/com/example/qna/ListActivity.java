package com.example.qna;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<String> items = Arrays.asList("종이", "플라스틱", "유리", "유리조각", "비닐");
    private List<String> trash = Arrays.asList("계란껍데기 (일반쓰레기)","갑각류 (일반쓰레기)","음식물쓰레기","캔","폐형광등 (형광등 폴더 선택해서 하나만)","유리병 (맥주병)","스티로폼 (배달용기)",
            "비닐 (뽁뽁이, 라면용기)","플라스틱 (일반 플라스틱... HDPE)","페트병( 투명한 페트병)","장난감","종이류","종이곽(우유, 음료수)","의류","도기류 (안타는 쓰레기로 분류해주세요)",
            "고철류","대형폐기물 ( 가구, 전자제품, 자전거 )","일반쓰레기");
    public String[] posts = {"장난감은 어떻게 분리배출하나요?",
            "오늘 이런 일이 있었습니다",
            "공이 오래돼서 그런데.." + "\n" +
                    "공은 어떻게 분리배출하나요?",
            "이 지역의 분리배출 요일이 궁금합니다.",
            "옷은 어떻게 분리배출하나요?",
            "분리수거 시간이 궁금해요!",
            "이런게 궁금해요.",
            "장난감은 어떻게 분리배출하나요?",
            "아파트 분리수거에 대해 문의하고 싶은 사항...",
            "장난감은 어떻게 분리배출하나요?",
            "옷 수거함이 어디있을까요?",
            "내일이 분리수거하는 날 맞나요?",
            "다들 분리수거할 때 역할 분담을 하시나요?",
            "장난감은 어떻게 분리배출하나요?",
            "어제 이런 일이 있었어요.."
    };


    private ArrayList<PostList> PList;
    private MyRecyclerAdapter myRecyclerAdapter;
    private ListView postView;
    private LinearLayoutManager linearLayoutManager;

    private DrawerLayout drawerLayout;
    private View drawerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (View) findViewById(R.id.drawer);

        Button btn_open = (Button) findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerView);
            }
        });

        Button btn_write = (Button) findViewById(R.id.btn_write);
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, WriteActivity.class);
                startActivity(intent);
            }
        });

        Button btn_first = (Button) findViewById(R.id.btn_first);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        Button btn_second = (Button) findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        Button btn_third = (Button) findViewById(R.id.btn_third);
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });

        Button btn_home = (Button) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //drawerLayout.closeDrawers();
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
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

//        SearchView searchView = findViewById(R.id.search_view);
//        TextView resultTextView = findViewById(R.id.textView);
//        resultTextView.setText(getResult());
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) { // 바로바로 변함
//                resultTextView.setText(search(newText));
//                return true;
//            }
//        });

        postView = (ListView)findViewById(R.id.postView);
        //linearLayoutManager = new LinearLayoutManager(this);
        //postView.setLayoutManager(linearLayoutManager);
        //PList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, posts);
        postView.setAdapter(adapter);

        postView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(), posts[arg2],
                        Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                //startActivity(intent);
            }
        });
        //myRecyclerAdapter = new MyRecyclerAdapter(PList);
        //recyclerView.setAdapter(myRecyclerAdapter);

        /*for(int i=0; i<=posts.size(); i++)
        {
            PList.add(new PostList(posts.get(i)));
        }*/
        //myRecyclerAdapter.notifyDataSetChanged();
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