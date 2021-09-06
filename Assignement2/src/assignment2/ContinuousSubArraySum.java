package assignment2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//3. Given an unsorted array A of size N, find a continuous sub-array which  sums up to S.
//        For example if the input array is [ -12,7,29,6, 2, 11,4,8] and the  expected sum is 8,
//        then there are two possibilities [6,2] and [8]
//        if the expected sum is 19 there are two possibilities [12,7] and [6,2,11].  [11,8] is not a possibility since it's not continuous.
public class ContinuousSubArraySum {

    public static void main(String[] args) {

        int[] arr = {-12,7,29,6, 2, 11,4,8};
        int targetSum = 8;


        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Integer> list =new ArrayList<>();
        list.add(-1);
        hm.put(0,list);

        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(hm.containsKey(sum-targetSum)){
                List<Integer> temp = hm.get(sum-targetSum);
                for(int t: temp){
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr,t+1,i+1)));
                }
            }

            hm.putIfAbsent(sum,new ArrayList<>());
            hm.get(sum).add(i);

        }
    }
}
