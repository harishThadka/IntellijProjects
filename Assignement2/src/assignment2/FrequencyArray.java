package assignment2;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class  FrequencyArray {

//    1. Given an array, print all the elements whose frequency is one, that is they do not have duplicates.
    public static void main(String[] args) {
//        Example: Array = [-1, -2, 3, 3, -2] Output = -1

        int[] arr = {-1, -2, 3, 3, -2,5};

        HashSet<Integer> hs = new HashSet<>();

        for(int i: arr){
            if(!hs.add(i)){ 
                hs.remove(i);
            }
        }

        System.out.println(hs.toString());

    }

}
