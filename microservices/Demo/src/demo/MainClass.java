package demo;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Demo");

        int[] arr={2,4,6,10,13,16};

        int l=0,r=arr.length-1;
        int key=4;

        int result  = binarySearch(arr,l,r,key);

        if(result==-1)
            System.out.println("Element not found");
        else
            System.out.println("Element found: "+result);


//        Binary Search
//        Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//        Example 1:
//        Input: nums = [-1,0,3,5,9,12], target = 9
//        Output: 4
//        Explanation: 9 exists in nums and its index is 4



    }

    static int binarySearch(int[] arr,int l,int r, int key){
        if(r >=l){
            int mid =l+(r-l)/2;
            System.out.println(mid);
            if(arr[mid] == key){
                return mid;
            }

            if(arr[mid] > key){
                return binarySearch(arr, l, mid-1,key);
            }

            if(arr[mid] < key){
                return binarySearch(arr,mid+1,r,key);
            }
        }

        return -1;
    }
}
