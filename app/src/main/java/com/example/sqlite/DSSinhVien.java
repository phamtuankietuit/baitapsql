package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DSSinhVien extends AppCompatActivity {
    private TextView tvIdClass, tvNameClass, tvStudentsClass;
    private RecyclerView rcvStudents;
    private List<SinhVien> mListSinhVien;
    private SinhVienAdapter mSinhVienAdapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dssinh_vien);

        database = new Database(this);

        initUI();

        getListSinhVien();
    }

    private void initUI() {
        tvIdClass = findViewById(R.id.tv_idclass);
        tvNameClass = findViewById(R.id.tv_nameclass);
        tvStudentsClass = findViewById(R.id.tv_studentsclass);

        rcvStudents = findViewById(R.id.rcv_student);

        rcvStudents.setHasFixedSize(true);
        rcvStudents.setItemViewCacheSize(20);
        rcvStudents.setDrawingCacheEnabled(true);
        rcvStudents.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvStudents.setLayoutManager(linearLayoutManager);

        mListSinhVien = new ArrayList<>();
        mSinhVienAdapter = new SinhVienAdapter(mListSinhVien);

        rcvStudents.setAdapter(mSinhVienAdapter);
    }

    private void getListSinhVien() {

    }
}