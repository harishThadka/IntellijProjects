package assignment1;

public class DistanceTwoWords {

    public static void main(String[] args) {

        String str1 = "ABC";
        String str2 = "XYZ";
        System.out.println(Math.abs(findMiddleWord(str1)-findMiddleWord(str2)));
    }

    public static char findMiddleWord(String s){
        return s.charAt(s.length()/2);
    }

}
