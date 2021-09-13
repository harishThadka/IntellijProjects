package interfaceConcepts;

import java.util.*;

public class InterfaceConceptMainClass {

    public static void main(String[] args) {

        Employee_Interface emp = new Developer();

        System.out.println(emp.id);
        System.out.println(emp.name);

        emp.print();

//        Need to call static methods via interface class only
//        emp.staticPrint();

        Developer dev = new Developer();

        dev.staticPrint();


       Teacher teacher = new Teacher();

       teacher.print();

//       List<String> list = Arrays.asList("Harish","thadka","ram","john");
//
//        Collections.sort(list, String::compareTo);
//
//        System.out.println(list);

    }
}
