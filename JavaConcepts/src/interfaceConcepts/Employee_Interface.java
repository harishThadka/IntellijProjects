package interfaceConcepts;

import java.util.List;

public interface Employee_Interface {
    
    int id = 100;
    String name = "harish";

    int getId();



    String getName();

   default void print(){
        System.out.println("Employee Interface");

    }

   static void staticPrint(){
        System.out.println("Static Employee Interface");
    }
    
}
