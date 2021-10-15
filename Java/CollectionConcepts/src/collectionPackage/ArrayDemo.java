package collectionPackage;

import java.util.Arrays;

public class ArrayDemo {

    public static void main(String[] args) {

        // default value is the null character, that is, '\u0000'
        char[] arr= new char[5];
        int[] arr2 = new int[]{5,6,7,8};
        int[] arr3 = {9,10,11};

        System.out.println("Arr: "+ Arrays.toString(arr)+" "+arr.length);

        System.out.println("Arr 2: "+ Arrays.toString(arr2)+" "+arr2.length);

        System.out.println("Arr 3: "+ Arrays.toString(arr3)+" "+arr3.length);



    }
}
