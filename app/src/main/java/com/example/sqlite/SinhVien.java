package com.example.sqlite;

public class SinhVien {
    private int id;
    private String name;
    private String dob;
    private int id_class;
    private Integer resourceId;

    public SinhVien() {
    }

    public SinhVien(int id, String name, String dob, int id_class, Integer resourceId) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.id_class = id_class;
        this.resourceId = resourceId;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getId_class() {
        return id_class;
    }

    public void setId_class(int id_class) {
        this.id_class = id_class;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }
}
