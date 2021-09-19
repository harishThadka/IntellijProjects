package assignment1;

public class LengthEncodingString {

    public static void main(String[] args) {

//        i/p: aabbccaaa  o/p: a2b2c2a3
        String s = "aabbccaaa";
        int start = 0;
        char prevChar = s.charAt(0);
        char currChar = '0';
        String output = "";
        for(int end=1;end<s.length();end++){
            currChar = s.charAt(end);
            if(prevChar != currChar){
                output += Character.toString(prevChar)+(end-start);
                start = end;
                prevChar = currChar;
            }
        }
        output += Character.toString(currChar)+(s.length()-start);
        System.out.println(output);
    }
}
