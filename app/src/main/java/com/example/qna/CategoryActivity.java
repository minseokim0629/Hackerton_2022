package com.example.qna;

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

public class CategoryActivity extends AppCompatActivity {

    private List<String> items = Arrays.asList("종이", "플라스틱", "유리", "유리조각", "비닐");
    private List<String> trash = Arrays.asList("계란껍데기","갑각류","음식물쓰레기","캔","폐형광등","유리병","스티로폼",
            "비닐","플라스틱","페트병","장난감","종이류","종이곽","의류","도기류",
            "고철류","대형폐기물","일반쓰레기");
    private List<String> recycle = Arrays.asList("사료나 퇴비로 만들 수 없으므로 일반 종량제 봉투로 배출해주세요.",
            "동물이 먹을 수 없는 딱딱한 껍질은 일반 종량제 봉투로 배출해주세요.",
            "사료나 퇴비로 이용가능한 음식물을 배출해주세요.\n공동 주택의 경우, 중간 수거 용기에 물기를 제거한 후 배출하시고, 단독주택의 경우, 전용 수거 용기(3l~120l)에 담아 납부필증을 부착 후 배출해주세요.",
            "겉 또는 속의 플라스틱 뚜껑 등을 제거한 후 내용물을 비우고 배출해주세요.",
            "깨지지 않도록 주의하여 형광등 판매처, 동사무소, 아파트 관리사무소 형광등 수집함에 배출해주세요.\n단, 깨진 형광등은 종량제봉투에 담아서 배출해주세요.",
            "플라스틱이나 알루미늄 뚜껑 제거 후 내용물을 깨끗이 비운 후 배출해주세요.\n깨진 유리는 신문지에 싸서 종량제 봉투에 버리고, 양이 많을 경우 특수구격마대(불연물질)를 구매하여 배출해주세요.",
            "내용물을 비우고 물로 헹구는 등 이물질을 제거하여 배출해주세요.\n음식물 등의 이물질이 묻은 경우 일반 종량제 봉투로 배출해주세요.",
            "음식물 등의 이물질을 제거하고, 흩날리지 않도록 봉투에 담아 배출해주세요.\n이물질제거가 어려운 경우 일반 종량제 봉투에 배출해주세요.",
            "내용물을 깨끗이 비우고 가능한 압착하여 배출해주세요.",
            "내용물을 비우고, 겉에 붙은 비닐 라벨을 깨끗이 제거하고 압착 후 뚜껑을 닫아 유색페트병은 플라스틱으로, 투명페트병은 별도로 분리해주세요.\n단, 뚜껑을 닫지 않고도 충분히 압착 및 이물질을 제거한 상태라면 뚜껑을 닫지 않고 배출해도 됩니다.",
            "재질별로 분리 후 재활용품으로 배출해주세요.\n재질별 분리가 어려울 경우 일반 쓰레기로 배출하시고, 대형 완구류는 대형 폐기물로 신고 후, 배출수수료를 납부하고 배출해야합니다.",
            "이물질(스프링, 테이프, 철핀 등)을 제거하고, 투명비닐 봉지에 담거나 묶어서 배출해주세요.",
            "내용물을 비우고 물로 헹구는 등 이물질(빨대, 비닐 등)을 제거하고 물로 헹군 뒤 말려서 펼친 상태로 일반 종이류와 혼합되지 않게 구분하여 배출해주세요.",
            "물기가 닿지 않도록 투명비닐봉지에 담아서 배출하거나 의류수거함에 넣어주세요.\n(걸레, 수건 등은 재활용이 불가능하므로, 일반종량제 봉투에 버려야합니다.)",
            "도기류는 불에 타지 않은 폐기물이므로, 불연재 봉투로 배출해주세요.",
            "이물질이 섞이지 않도록 한 후 봉투에 넣거나 끈으로 묶어서 배출해주세요.\n단, 재질 혼합 제품은 재활용이 불가합니다.",
            "동사무소에 반드시 신고 후 신고필증을 부착하여 배출해야합니다.\n(단, 원형이 훼손되지 않은 대형 폐가전의 경우 무상 방문수거 예약 배출이 가능합니다.)",
            "종량제 전용 봉투에 묶음선 이하로 담아 묶어서 수거일 전일, 일몰 후에 배출해주세요. ");


    private ArrayList<TrashList> TList;
    private MyRecyclerAdapter myRecyclerAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private DrawerLayout drawerLayout;
    private View drawerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

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
                Intent intent = new Intent(CategoryActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        Button btn_first = (Button) findViewById(R.id.btn_first);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        Button btn_second = (Button) findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

        Button btn_third = (Button) findViewById(R.id.btn_third);
        btn_third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, MyActivity.class);
                startActivity(intent);
            }
        });

        Button btn_home = (Button) findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //drawerLayout.closeDrawers();
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
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

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        TList = new ArrayList<>();

        myRecyclerAdapter = new MyRecyclerAdapter(TList);
        recyclerView.setAdapter(myRecyclerAdapter);

        for(int i=0; i<=17; i++)
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