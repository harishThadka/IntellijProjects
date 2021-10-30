package sortAlgorithms;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {20,35,-15,7,55,1,-22};

        int n = arr.length;
        // Bubble sort in ascending order
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){ // n-i-1 to decrease the length of inner loop
                    if(arr[j] > arr[j+1]){
                        swap(arr,j,j+1);
                    }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(int[] array, int i,int j){
        if(i==j){
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
