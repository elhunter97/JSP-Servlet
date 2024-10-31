package com.javaweb.mvc.dto;

public class StudentDTO {
    private int id;
    private String name;
    private String address;
    private double point;
    private String nameClass;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, String address, double point, String nameClass) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.point = point;
        this.nameClass = nameClass;
    }

    public StudentDTO(String name, String address, double point, String nameClass) {
        this.name = name;
        this.address = address;
        this.point = point;
        this.nameClass = nameClass;
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

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
}
