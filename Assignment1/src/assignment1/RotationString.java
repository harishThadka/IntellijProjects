package assignment1;

public class RotationString {

//    determine whether one string is a rotation of another string
    public static void main(String[] args) {

//        i/p: String 1: abcde   String 2: deabc
//        o/p: Second string is a rotation of first string

        String str1 = "abcde";
        String str2 = "deabc";

        System.out.println(checkRotationString(str1,str2) ? "Rotation Strings": "Not Rotation Strings");


    }

    public static boolean checkRotationString(String str1,String str2){

        if(str1.length() != str2.length())
            return false;

        return  (str1+str1).contains(str2);
    }
}
