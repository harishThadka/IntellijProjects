package sortAlgorithms;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] arr = {20,35,-15,7,55,1,-22};
        int n = arr.length;

        // i starts from 1 since first element is sorted
        for(int i=1;i<n-1;i++){
            int newElement = arr[i];
            int j;
            for(j=i;j>0&&arr[j-1]>newElement;j--){
                arr[i] = arr[i-1];
            }
            arr[j]=newElement;
        }

        System.out.println(Arrays.toString(arr));
    }

}
