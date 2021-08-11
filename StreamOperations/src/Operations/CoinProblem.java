package Operations;

import java.util.HashMap;
import java.util.Map;

public class CoinProblem {

    public static void main(String[] args) {
        System.out.println("hello world");
        int[] arr = {50,20,10,5,1};
        System.out.println(minimumCoins(arr,102));
    }

    public static int minimumCoins(int[] coins, int balance){

        if(balance==0){
            return 0;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<coins.length;i++){
            int coin = coins[i];

            if(balance>= coin){
                int count = (balance/coin);
                balance = balance%coin;
                System.out.println("count: "+count+"balance: "+balance);
                map.put(coin,count);
            }
        }

        System.out.println("Coins Map: "+ map);

        return  map.values().stream()
                .mapToInt(Integer::valueOf).sum();


    }
}
