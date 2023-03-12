package org.wb.leetcode.medium;

public class UndergroundRailwayTest {

    public static void main(String[] args) {
        UndergroundRailway ur = new UndergroundRailway();
        ur.checkIn(45,"Leyton",3);
        ur.checkIn(32,"Paradise",8);
        ur.checkIn(27,"Leyton",10);
        ur.checkOut(45,"Waterloo",15);
        ur.checkOut(27,"Waterloo",20);
        ur.checkOut(32,"Cambridge",22);
        System.out.println(ur.getAverageTime("Paradise","Cambridge"));
        System.out.println(ur.getAverageTime("Leyton","Waterloo"));
        ur.checkIn(10,"Leyton",24);
        System.out.println(ur.getAverageTime("Leyton","Waterloo"));
        ur.checkOut(10,"Waterloo",38);
        System.out.println(ur.getAverageTime("Leyton","Waterloo"));
    }
}
