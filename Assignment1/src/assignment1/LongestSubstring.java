package assignment1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

    public static void main(String[] args)
    {
        String str = "aaabcbdeaf";

        Map<Character, Integer> visitedCharacters = new HashMap<>();
        String output = "";

        for (int start = 0, end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            if (visitedCharacters.containsKey(currChar)) {
                start = Math.max(visitedCharacters.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = str.substring(start, end + 1);
            }
            visitedCharacters.put(currChar, end);
        }
    }
}
