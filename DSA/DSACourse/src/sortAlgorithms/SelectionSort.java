package sortAlgorithms;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {20,35,-15,7,55,1,-22};
        int n = arr.length;

        for(int i=0;i<n-1;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[i]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
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
