package assignment1;

public class CheckAnagram {

//    determine whether two strings are the anagram
    public static void main(String[] args) {

//        i/p: String str1="Brag";
//        String str2="Grab";
//        0/p: true

        String str1 = "Brag";
        String str2 = "Grab";


        System.out.println(checkAnagram(str1.toLowerCase(),str2.toLowerCase()) ? "Anagrams" : "Not Anagrams");

    }

    public  static boolean checkAnagram(String str1,String str2){

        if(str1.length() != str2.length())
            return false;

        // Number of distinct characters in ASCII System are 256
        int[] charArray = new int[256];

        for(int i =0;i<str1.length();i++){
            charArray[str1.charAt(i)]++;
            charArray[str2.charAt(i)]--;

        }

        for (int i: charArray){
            if(i!= 0)
                return false;
        }

        return true;


    }
}
