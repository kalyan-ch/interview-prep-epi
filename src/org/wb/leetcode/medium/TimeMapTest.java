package org.wb.leetcode.medium;

public class TimeMapTest {
    public static void main(String[] args) {
        TimeBasedKeyMap tb = new TimeBasedKeyMap();
        tb.set("ljfvbut","tatthnvvid",3);
        System.out.println(tb.get("ljfvbut",4));
        System.out.println(tb.get("ljfvbut",5));
        System.out.println(tb.get("ljfvbut",6));
        System.out.println(tb.get("ljfvbut",7));
        tb.set("eimdon","pdjbnnvje",8);
        System.out.println(tb.get("eimdon",9));
        System.out.println(tb.get("eimdon",10));
    }
}
