package assignment1;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxOccurenceCharacter {

//    Max occurance of a charecter in the String with index and its max count
    public static void main(String[] args) {

//        i/p: aabbbbbbbbbbccccc o/p: char='b' index=2 count=10

        String s = "aabbbbbbbbbbccccc";

        Map<Character,Long> freqChars = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Optional<Map.Entry<Character, Long>> maxEntry = freqChars.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));

        char out = maxEntry.get().getKey();
        System.out.println("Output: "+ "Char: "+out+" Index: "+s.indexOf(out)+" Count: "+maxEntry.get().getValue());


    }
}
