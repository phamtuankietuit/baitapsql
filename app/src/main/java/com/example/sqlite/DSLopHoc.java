package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowId;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DSLopHoc extends AppCompatActivity {
    private RecyclerView rcvClass;
    private List<LopHoc> mListLopHoc;
    private LopHocAdapter mLopHocAdapter;

    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dslop_hoc);

        database = new Database(this);


        initUI();
        getListLopHoc();
    }

    private void initUI() {
        rcvClass = findViewById(R.id.rcv_lophoc);

        rcvClass.setHasFixedSize(true);
        rcvClass.setItemViewCacheSize(20);
        rcvClass.setDrawingCacheEnabled(true);
        rcvClass.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvClass.setLayoutManager(linearLayoutManager);

        mListLopHoc = new ArrayList<>();
        mLopHocAdapter = new LopHocAdapter(mListLopHoc, DSLopHoc.this, new Callback() {
            @Override
            public void callback(Intent intent) {
                startActivity(intent);
            }
        });

        rcvClass.setAdapter(mLopHocAdapter);
    }

    private void getListLopHoc() {

        Cursor dataLopHoc = database.getData("SELECT * FROM LopHoc");

        while (dataLopHoc.moveToNext()) {
            String name = dataLopHoc.getString(1);
            int id = dataLopHoc.getInt(0);
            int students = dataLopHoc.getInt(2);
            mListLopHoc.add(new LopHoc(id,name,students));
        }

        mLopHocAdapter.notifyDataSetChanged();
    }
}