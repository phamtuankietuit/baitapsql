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

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
}
