package com.example.qna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StoreActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ImageButton button1 = (ImageButton) findViewById(R.id.image1);
        ImageButton button2 = (ImageButton) findViewById(R.id.image2);
        ImageButton button3 = (ImageButton) findViewById(R.id.image3);
        ImageButton button4 = (ImageButton) findViewById(R.id.image4);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("http://greenkokkiri.co.kr/"));
                //인텐트를 통해 액션뷰를 띄움. Uri.parse("이동할 사이트")
                startActivity(myIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.119reo.com/"));
                //인텐트를 통해 액션뷰를 띄움. Uri.parse("이동할 사이트")
                startActivity(myIntent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://shop.29cm.co.kr/brand/2746"));
                //인텐트를 통해 액션뷰를 띄움. Uri.parse("이동할 사이트")
                startActivity(myIntent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://artimpact.kr/Social-Value-Design/view/604755"));
                //인텐트를 통해 액션뷰를 띄움. Uri.parse("이동할 사이트")
                startActivity(myIntent);
            }
        });

    }
}