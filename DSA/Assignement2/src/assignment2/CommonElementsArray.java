package assignment2;


//4.Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that
//        appeared in all three arrays in O(n). Make sure the time complexity is met.
//
//        Example 1:
//        Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
//        Output: [1,5]
//        Explanation: Only 1 and 5 appeared in the three  arrays.
public class CommonElementsArray {

    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,5,7,9};
        int[] arr3 = {1,3,4,5,8};

        for(int i=0,j=0,k=0;i< arr1.length;i++,j++,k++){
            if(arr1[i]==arr2[i]&& arr1[i]==arr3[i]){
                System.out.println(arr1[i]);
            }
        }

    }
}
