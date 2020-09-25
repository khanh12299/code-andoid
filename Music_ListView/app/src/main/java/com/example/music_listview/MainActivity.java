package com.example.music_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    ArrayList<List_ca_si> listcasiArrayList;
    Ca_si_adapter caSiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1 = (ListView) findViewById(R.id.list_view1);
        //khởi tạo danh sách mảng
        listcasiArrayList = new  ArrayList<>();

        listcasiArrayList.add(new List_ca_si("Live a light on","justin biber",R.drawable.justin));
        listcasiArrayList.add(new List_ca_si("Thương em là điều anh không thể ngờ","Noo Phước Thịnh",R.drawable.noo));
        listcasiArrayList.add(new List_ca_si("Một Cú Lừa","Bích Phương ",R.drawable.bichphuong));
        listcasiArrayList.add(new List_ca_si("chắc ai đó sẽ về","sơn tùng M-TP",R.drawable.sontung));
        listcasiArrayList.add(new List_ca_si("phía sau một cô gái ","Subin hoàng sơn",R.drawable.subin));
        listcasiArrayList.add(new List_ca_si("ngọn cỏ ven đường ","mir siro",R.drawable.siro));

        caSiAdapter = new Ca_si_adapter(this,R.layout.dong_ca_si, listcasiArrayList);
        listView1.setAdapter(caSiAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this,MainActivity_song.class);
                intent.putExtra("nang tho",i);
                startActivity(intent);
            }
        });

    }

}