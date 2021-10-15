package collectionPackage.listPackage;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList<>();

        linkedList.add(10);
        linkedList.add(20);
        linkedList.get(0);
        System.out.println(linkedList.get(1));
        System.out.println(linkedList);
    }
}
