package org.wb.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;

public class UniqueEmails {

    private static int findUniqueEmails(String[] emails){
        HashSet<String> uniqueEmails = new HashSet<>();

        for (String email: emails) {
            String[] emailArr = email.split("@");
            String firstPart = emailArr[0].split("\\+")[0];
            String finalLocalName = String.join("", firstPart.split("\\."));

            String finalEmail = finalLocalName+"@"+emailArr[1];
            uniqueEmails.add(finalEmail);
        }

        return uniqueEmails.size();
    }
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        String[] emails2 = {"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
        System.out.println(findUniqueEmails(emails));
        System.out.println(findUniqueEmails(emails2));
    }
}
