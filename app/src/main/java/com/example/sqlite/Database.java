package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DATABASE.db";


    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CreateClassTable =
        "CREATE TABLE IF NOT EXISTS LopHoc (id INTEGER PRIMARY KEY AUTOINCREMENT, name NVARCHAR(200), students INT);";
        sqLiteDatabase.execSQL(CreateClassTable);

        String CreateStudentTable =
                "CREATE TABLE IF NOT EXISTS SinhVien (id INTEGER PRIMARY KEY AUTOINCREMENT, name NVARCHAR(200), dob VARCHAR(200), id_class INTEGER, resourceId INT, FOREIGN KEY(id_class) REFERENCES LopHoc(id));";
        sqLiteDatabase.execSQL(CreateStudentTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LopHoc");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SinhVien");
        onCreate(sqLiteDatabase);
    }

    public void addNewClass() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO LopHoc (id, name, students) VALUES (null,'KTPM2022',110)");
        db.execSQL("INSERT INTO LopHoc (id, name, students) VALUES (null,'HTTT2021',100)");
        db.execSQL("INSERT INTO LopHoc (id, name, students) VALUES (null,'KHMT2020',30)");
        db.execSQL("INSERT INTO LopHoc (id, name, students) VALUES (null,'KTPM2019',50)");
    }

    public void addNewStudent() {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Van A','28/04/2003',1,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Van B','28/04/2003',2,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Van C','28/04/2003',3,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Van D','28/04/2003',4,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Van E','28/04/2003',5,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Thi A','28/04/2003',1,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Thi B','28/04/2003',2,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Thi C','28/04/2003',3,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Thi D','28/04/2003',4,700004)");
        db.execSQL("INSERT INTO SinhVien (id, name, dob, id_class, resourceId) VALUES (null,'Nguyen Thi E','28/04/2003',5,700004)");
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    public List<LopHoc> getAllClass() {

        List<LopHoc> list = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LopHoc", null);

        while (cursor.moveToNext()) {
            Integer class_id = cursor.getInt(0);
            String class_name = cursor.getString(1);
            Integer class_students = cursor.getInt(2);

            list.add(new LopHoc(class_id, class_name, class_students));
        }
        return list;
    }

    public List<SinhVien> getAllStudent() {

        List<SinhVien> list = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM SinhVien", null);

        while (cursor.moveToNext()) {
            Integer student_id = cursor.getInt(0);
            String student_name = cursor.getString(1);
            String student_dob = cursor.getString(2);
            Integer student_id_class = cursor.getInt(3);
            int student_resourceId = cursor.getInt(4);

            list.add(new SinhVien(student_id, student_name, student_dob, student_id_class, student_resourceId));
        }
        return list;
    }
}
