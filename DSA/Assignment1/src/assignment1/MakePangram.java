package assignment1;

public class MakePangram {

//    Missing characters to make a string Pangram
    public static void main(String[] args) {

        String str="writing pangram program using java";
        char s[]=str.toCharArray();
        int c[]=new int[26];
        for(int i=0;i<s.length;i++){
            if(s[i]!=' '){
                c[s[i]-'a']++;
            }
        }
        String output="";
        for(int i=0;i<26;i++){
            if(c[i]==0){
                output += (char)(i+'a');
            }
        }
        System.out.println(output);
    }
}
