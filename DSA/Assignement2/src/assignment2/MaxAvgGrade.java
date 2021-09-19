package assignment2;

import java.util.*;

public class  MaxAvgGrade {

//    2.For a given input 2D array of strings, find the maximum average grade, round off to the nearest floor integer.

    //            Input:  String[][] scores= { {"Rohit", "85"},
//                                      {"Rahul", "80"}
//                                      {"Amit","85"},
//                                      {"Rohit", "90"} }
//    Output : 87
//    Logic : Rohit's average grade is (85+90)/2 = 87.5 which when rounded off to floor is 87
    public static void main(String[] args) {

        String[][] scores = {{"Rohit", "85"}, {"Rahul", "80"}, {"Amit", "85"}, {"Rohit", "90"}};

        System.out.println(Integer.toString(45,3));

        Map<String, int[]> scoreMap = new HashMap<>();
        for (String[] score : scores) {
            String name = score[0];
            int currentScore = Integer.parseInt(score[1]);

            if (scoreMap.containsKey(name)) {
                int[] scoreCount = scoreMap.get(name);
                scoreCount[0] += currentScore;
                scoreCount[1]++;
                scoreMap.put(name, scoreCount);
            } else {
                int[] scoreCount = new int[]{currentScore, 1};
                scoreMap.put(name, scoreCount);
            }
        }

        int maxAvg = 0;
        for (int[] value : scoreMap.values()) {
            int average = (int) Math.floor(value[0] / value[1]);
            if (average > maxAvg)
                maxAvg = average;
        }

        System.out.println(maxAvg);
    }
}
