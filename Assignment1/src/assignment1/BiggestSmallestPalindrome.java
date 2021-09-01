package assignment1;

//Program to print smallest and biggest possible palindrome word in a given string
public class BiggestSmallestPalindrome {

    public static void main(String[] args) {

        String input = "aba abbbaaa abdhbj ajdn nitin";

        String[] words = input.split(" ");

        String smallestPalindrome = "";
        String largestPalindrome = "";
        int count = 0;
        for(String s: words ){
            count++;
            if(checkPalindrome(s)){
                if(count == 1){
                    smallestPalindrome = largestPalindrome = s;
                }else{
                    if(smallestPalindrome.length() > s.length()){
                            smallestPalindrome = s;
                    }

                    if(largestPalindrome.length() < s.length()){
                        largestPalindrome = s;
                    }
                }


            }
        }

        System.out.println("Smallest Palindrome: "+ smallestPalindrome);
        System.out.println("Largest Palindrome: "+ largestPalindrome);

    }

    public static boolean checkPalindrome(String str){


        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
