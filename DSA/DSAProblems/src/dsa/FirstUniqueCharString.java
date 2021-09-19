package dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstUniqueCharString {

    // Find first unique Character in the string
//    public static void main(String[] args) {
//
//        // Output Index: 2, v
////        String s = "loveleetcode";
//        // Output Index: -1
//        String s = "aabbcc";
//
//        Map<Character, Long> hm = s.chars().mapToObj(c->(char)c)
//                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//
////        System.out.println(hm);
//        Optional<Character> uniqueChar = s.chars().mapToObj(c->(char)c)
//                .filter(c -> hm.get(c)==1).findFirst();
//
//        if(uniqueChar.isEmpty()){
//            System.out.println(-1);
//        }else{
//            System.out.println(s.indexOf(uniqueChar.get()));
//        }
//    }

    public static void main(String[] args) {
//         Output Index: 2, v
        String s = "loveleetcode";

        int[] charArray = new int[256];

        Arrays.fill(charArray,-1);

//        for(int i=0;i<s.length();i++){
//
//            if(charArray[s.charAt(i)] == -1){
//                charArray[s.charAt(i)] = i;
//            }else{
//                charArray[s.charAt(i)] = -2;
//            }
//        }

        s.chars().forEach(c-> {
            if(charArray[c] == -1){
              charArray[c] = s.indexOf(((char)c));
            }else{
                charArray[c] = -2;
            }

        });

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
