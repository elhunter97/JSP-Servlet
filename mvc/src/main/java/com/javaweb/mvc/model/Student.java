package com.javaweb.mvc.model;

public class Student {
    private int id;
    private String name;
    private String address;
    private double point;
    private int id_Class;

    public Student(int id, String name, String address, double point) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
    }

    public Student(String name, String address, double point, int id_Class) {
        this.name = name;
        this.address = address;
        this.point = point;
        this.id_Class = id_Class;
    }

    public Student(int idEdit, String name, String address, double point, int idClass) {
        this.id = idEdit;
        this.name = name;
        this.address = address;
        this.point = point;
        this.id_Class = idClass;
    }

    public int getId() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public int getId_Class() {
        return id_Class;
    }

    public void setId_Class(int id_Class) {
        this.id_Class = id_Class;
    }
}
