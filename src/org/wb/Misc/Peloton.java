package org.wb.Misc;

import java.util.*;

public class Peloton {

    public static void main(String[] args) {
        String[] rounds = {"AABABBABAA", "ABABBB", "BBAABAABBB"};
        for(String r: rounds){
            for(String w: determineWinnersWithTie(r)){
                System.out.print(w+" ");
            }
            System.out.println();
        }
    }

    private static List<String> determineWinnersWithTie(String rounds){
        List<String> result = new ArrayList<>();
        int[] scores = {0, 20, 40, 55};
        String tie = "Tie";
        String adv = "Adv %s";
        String winA = "Player A wins";
        String winB = "Player B wins";

        boolean hasGameReachedTie = false;
        boolean isTie = false;

        int roundsAWon = 0, roundsBWon = 0;

        for(int i = 0; i < rounds.length(); i++){
            char roundWinner = rounds.charAt(i);
            StringBuilder sb = new StringBuilder();
            if(roundWinner == 'A'){
                roundsAWon++;
            } else {
                roundsBWon++;
            }

            int aScore = roundsAWon < 4 ? scores[roundsAWon] : 0;
            int bScore = roundsBWon < 4 ? scores[roundsBWon] : 0;

            String score = sb.append(aScore).append("-").append(bScore).toString();

            if(i < 5){
                result.add(score);
            } else {
                isTie = roundsAWon == roundsBWon;
                if(isTie){
                    hasGameReachedTie = true;
                    String res = roundsAWon < 4 ? score : tie;
                    result.add(res);
                } else {
                    if(!hasGameReachedTie){
                        result.add(score);
                    } else {
                        int diff = Math.abs(roundsAWon - roundsBWon);

                        if(diff >= 2){
                            result.add(roundsAWon > roundsBWon ? winA : winB);
                        } else {
                            String advPlayer = roundsAWon > roundsBWon ? "A" : "B";
                            result.add(String.format(adv, advPlayer));
                        }
                    }
                }
            }

            if(!hasGameReachedTie){
                if(roundsAWon == 4){
                    result.add(winA);
                    break;
                }
                if(roundsBWon == 4){
                    result.add(winB);
                    break;
                }
            }
        }

        return result;
    }

}
