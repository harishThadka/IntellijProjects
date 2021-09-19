package assignment1;

import java.util.Arrays;

public class FirstUniqueCharString {
    public static void main(String[] args) {
//         Output Index: 2, v
        String s = "aabdcce";

        int[] charArray = new int[256];

        Arrays.fill(charArray,-1);

        for(int i=0;i<s.length();i++){

            if(charArray[s.charAt(i)] == -1){
                charArray[s.charAt(i)] = i;
            }else{
                charArray[s.charAt(i)] = -2;
            }
        }


        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<charArray.length;i++){

            if(charArray[i] >= 0){
                minIndex = Math.min(minIndex,charArray[i]);
            }

        }

        int out = minIndex == Integer.MAX_VALUE ? -1 : minIndex;

        System.out.println(out);
    }
}
