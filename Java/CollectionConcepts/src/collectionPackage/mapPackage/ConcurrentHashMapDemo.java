package collectionPackage.mapPackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap<Integer,String> conMap = new ConcurrentHashMap<>();

        conMap.put(1,"apple");
        conMap.put(2,"iphone");
        conMap.put(3,"samsung");


        Iterator iterator = conMap.keySet().iterator();

        while(iterator.hasNext()){
            System.out.println(conMap.get(iterator.next()));
            conMap.remove(2);
        }

        System.out.println(conMap);
    }
}
