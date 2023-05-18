package com.example.sqlite;

public class LopHoc {
    private int id;
    private String name;
    private Integer student;

    public LopHoc() {
    }

    public LopHoc(int id, String name, int student) {
        this.id = id;
        this.name = name;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }
}
