package com.itvdn.jdbcandhibernate.HomeTask1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBWorker HT1 = new DBWorker();
        Towel tow1 = new Towel("White-red", 120, 55, 1);
        HT1.addTowel(tow1);
        List<Towel> towels = HT1.getAllTowels();
        for (Towel tow : towels) {
            System.out.println(tow.getId() + " " + tow.getColour() + " " + tow.getLength() + " " + tow.getWidth() + " " + tow.getCount());
        }

    }
}
