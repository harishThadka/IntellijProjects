package collectionPackage.listPackage;

import java.util.*;

public class ArrayListDemo {


    public static void main(String[] args) {

        ArrayList arraylist = new ArrayList<>();


        arraylist.add(3);
        arraylist.add("9");
        arraylist.add("4");

        int k = Integer.parseInt(arraylist.get(1).toString());

        System.out.println(k);

        List<String> a2 = new ArrayList<>(100);

        Collection c = Arrays.asList("Hi","Hello");
        List<Integer> a3 = new ArrayList(c);


        // Autoboxing
        a3.add(150); // Converts int to Integer Object
        a3.remove(1);
        a3.add(200);
        a3.add(190);
        //Unboxing
        int var = a3.get(1); // Converts Integer Object to primitive data type int.
        a3.add(1,10);

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(101); numbers.add(200); numbers.add(301);
        numbers.add(400);
        System.out.println("ArrayList Before : " + numbers);
        Iterator<Integer> itr = numbers.iterator();
        // remove all even numbers
        while (itr.hasNext()) { Integer number = itr.next();
            if (number % 2 == 0) {
                // Below show concurrrent Modification Exception
//                numbers.remove(number);
                itr.remove();
            }
        }

        System.out.println("ArrayList After : " + numbers);






    }
}
