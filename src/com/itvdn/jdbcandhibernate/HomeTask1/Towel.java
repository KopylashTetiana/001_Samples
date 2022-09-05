package com.itvdn.jdbcandhibernate.HomeTask1;

public class Towel {
    private int id;
    private String colour;
    private int length;
    private int width;
    private int count;

    public Towel(int id, String colour, int length, int width, int count) {
        this.id = id;
        this.colour = colour;
        this.length = length;
        this.width = width;
        this.count = count;
    }
    public Towel(String colour, int length, int width, int count) {
        this.colour = colour;
        this.length = length;
        this.width = width;
        this.count = count;
    }

    public int getId() {
        return id;
    }
    public String getColour() {
        return colour;
    }
    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }
    public int getCount() {
        return count;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
