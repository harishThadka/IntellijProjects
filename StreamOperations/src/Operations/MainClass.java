package Operations;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import java.util.Map;

public class MainClass {

    public static void main(String[] args) {

        int result = IntStream.rangeClosed(1,10).reduce(1,(a,b)-> a+b);

        System.out.println("Result: "+result);

//        List<String> strList = Arrays.asList("HarishThadka".split(""));

        String listToString = Arrays.stream("HarishThadka".split("")).collect(Collectors.joining(", ", "[", "]"));

        System.out.println(listToString);

        /**
         *   Finding frequency of characters in a sentence
          */

            String sentence = "Hi this is harish, how you doing?";
            String newSentence = sentence.replaceAll(" ", "");
//            System.out.println(newSentence);
            Map<Character,Long> freqChars = newSentence.chars().mapToObj(c-> (char) c)
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println("Frequency of chars: "+freqChars);

        /**
         * find the first occurrence of repeated character in a string
         * Input - Mississippi
         * output- i
         */

        String word = "Mississippi";
        Map<Character,Long> charsMap = word.chars()
                .mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        Optional<Character> firstOccurrence = charsMap.entrySet()
                .stream()
                .filter(e-> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("Mississippi: "+firstOccurrence);

        /**
         * Reverse sentence
         * Input - my name is harish
         * output - ym eman si hsirarh
         */
        String sent = "my name is harish";
        Function<String,String> reverse =  s -> new StringBuilder(s).reverse().toString();
        List<String> reverseSentence = Arrays.asList(sent.split(" ")).stream()
                .map(s-> new StringBuilder(s).reverse().toString())
                .collect(Collectors.toList());

        System.out.println("Reverse sentence: "+reverseSentence);

        /**
         *  Dividing the numbers into even and odd using stream
         */

//        Map<Boolean,List<Integer>> evenNumbers = IntStream.rangeClosed(1,40)
//                .boxed() // converting IntStream to Stream<Integer>
//                .collect(Collectors.partitioningBy(i -> i%2 == 0));
//        System.out.println("Even Numbers: "+ evenNumbers.get(true));


        Map<String,List<Integer>> oddEvenNumbers = IntStream.rangeClosed(1,40)
                .boxed()
                .collect(Collectors.groupingBy(i -> i%2==0 ? "Even" :"Odd"));

        System.out.println("Even Numbers: "+oddEvenNumbers.get("Even"));
        System.out.println("Odd Numbers: "+oddEvenNumbers.get("Odd"));



        /**
         *  Minimum swaps required to sort an array of non-consecutive and non-repeated integers
         */

        int[] a = { 101, 758, 315, 730, 472, 619, 460, 479 };
        int [] b = Arrays.copyOf(a,a.length);
        Arrays.sort(b);
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<b.length;i++){
            map.put(b[i],i);
        }
        System.out.println(map);

        int count = 0;
        for(int i=0;i<a.length;i++){

            if(a[i] != b[i]){
                count++;
                int pos = map.get(a[i]);
                int temp = a[pos];
                a[pos] = a[i];
                a[i] = temp;
                i--;
            }
        }

        System.out.println("Sorted Array a: "+Arrays.toString(a));
        System.out.println("Count : "+ count);

    }

}
