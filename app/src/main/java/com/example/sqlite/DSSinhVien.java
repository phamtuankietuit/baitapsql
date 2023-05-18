package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.database.Cursor;
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
    private Database database;
    private String idCurrentClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dssinh_vien);

        database = new Database(this);

        initUI();

        Intent intent = getIntent();
        idCurrentClass = intent.getStringExtra("id");
        String name = intent.getStringExtra("name");
        String students = intent.getStringExtra("students");

        tvIdClass.setText(idCurrentClass);
        tvNameClass.setText(name);
        tvStudentsClass.setText(students);


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

        Cursor dataSinhVien = database.getData("SELECT * FROM SinhVien");

        while (dataSinhVien.moveToNext()) {
            Integer id_class = dataSinhVien.getInt(3);
            if (id_class.toString().equals(idCurrentClass)) {
                int id = dataSinhVien.getInt(0);
                String name = dataSinhVien.getString(1);
                String dob = dataSinhVien.getString(2);
                Integer resource = dataSinhVien.getInt(4);
                mListSinhVien.add(new SinhVien(id,name,dob,id_class,resource));
            }
        }
        mSinhVienAdapter.notifyDataSetChanged();
    }
}