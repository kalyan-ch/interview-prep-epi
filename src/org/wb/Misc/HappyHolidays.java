package org.wb.Misc;

import java.util.HashMap;
import java.util.Map;

public class HappyHolidays {

    public static void main(String[] args) {
        String[] inputs = {  "HappyHolidays","HolidaysHappy","holidayshappy", "ypyaHiHlspoda",
                "HappyHolidaysHappyHolidaysHappy","HappyHolidaysHappyHolidaysHolidaysHappy",
                "poHaadpilyHysyaypHHldaoipsHpaoapylyHdspohpaHldayysdlpHopyHiaas"};

        for(String s: inputs){
            System.out.println(s+": "+numberOfHappyHolidays(s));
        }

    }

    private static int numberOfHappyHolidays(String s){

        String sampleString = "HappyHolidays";
        Map<Character, Integer> holidayMap = new HashMap<>();
        for(int i = 0; i < sampleString.length(); i++){
            char c = sampleString.charAt(i);
            int num = holidayMap.getOrDefault(c, 0);
            holidayMap.put(c, ++num);
        }

        Map<Character, Integer> strMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int num = strMap.getOrDefault(c, 0);
            strMap.put(c, ++num);
        }

        return numHappyHolidays(holidayMap, strMap);
    }

    private static int numHappyHolidays(Map<Character, Integer> holidayMap, Map<Character, Integer> strMap){
        int numHHInStr = 0;
        while(lenStrMap(strMap) >= 13){
            if(removeHappyHolidaysFromMap(holidayMap, strMap))
                numHHInStr++;
            else
                break;
        }
        return numHHInStr;
    }

    private static boolean removeHappyHolidaysFromMap(Map<Character, Integer> holidayMap, Map<Character, Integer> strMap){
        for(Character c: holidayMap.keySet()) {
            int numCInStr = strMap.getOrDefault(c, 0);
            int numCInHM = holidayMap.get(c);
            if (numCInStr > 0)
                strMap.put(c, (numCInStr - numCInHM));
            else
                return false;

        }
        return true;
    }

    private static int lenStrMap(Map<Character, Integer> strMap){
        int sum = 0;
        for(Character c: strMap.keySet()){
            sum += strMap.get(c);
        }
        return sum;
    }

}
