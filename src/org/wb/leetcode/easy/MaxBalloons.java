package org.wb.leetcode.easy;

import java.util.*;
public class MaxBalloons {
    public static void main(String[] args) {

        String[] texts = {"krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw", "nlaebolko", "loonbalxballpoon", "fastgwfsdfs", "lloo"};

        for (String s: texts){
            System.out.println(maxNumberOfBalloons(s));
        }

    }

    public static int maxNumberOfBalloons(String text) {
        Set<Character> balloonChars = new HashSet<>(Arrays.asList('a', 'b', 'l', 'o', 'n'));
        Map<Character, Integer> balloonMap = new HashMap<>();

        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(balloonChars.contains(c)){
                balloonMap.put(c, balloonMap.getOrDefault(c, 0) + 1);
            }
        }

        int result = Integer.MAX_VALUE;
        balloonMap.put('l', balloonMap.getOrDefault('l', 0)/2);
        balloonMap.put('o', balloonMap.getOrDefault('o', 0)/2);


        for (char k: balloonChars){
            result = Math.min(result, balloonMap.getOrDefault(k, 0));
        }

        return result;
    }
}
