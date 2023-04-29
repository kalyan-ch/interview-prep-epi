package org.wb.leetcode.medium;

public class FileSystemTest {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        System.out.println(fs.createPath("/leet", 1));
        System.out.println(fs.createPath("/leet/code", 2));
        System.out.println(fs.get("/a"));
    }
}
