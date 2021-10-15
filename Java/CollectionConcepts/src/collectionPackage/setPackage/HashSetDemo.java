package collectionPackage.setPackage;

import collectionPackage.Employee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {

        Set<String> stringSet = new HashSet<>();

        stringSet.add("hi");
        stringSet.add("hello");
        boolean isAdded = stringSet.add("hi");
        System.out.println("Is added to set: "+isAdded);
        isAdded = stringSet.add("harish");
        System.out.println(isAdded);
        stringSet.add("java");

        System.out.println("String Set: "+stringSet);

        Set<Employee> employeeSet = new HashSet<>();

        Employee emp1 =new Employee(101,"harish");
        Employee emp2 = new Employee(102,"john");
        Employee emp3 = new Employee(103, "harish");
        Employee emp4 = new Employee(101,"william"); // Duplicate element
        Employee emp5 = new Employee();
        Employee emp6 = new Employee(); // Duplicate Element

        employeeSet.add(emp1);
        employeeSet.add(emp2);
        employeeSet.add(emp3);
        employeeSet.add(emp4);
        employeeSet.add(emp5);
        employeeSet.add(emp6);

        Employee emp7 =new Employee(101,"harish");
        employeeSet.remove(emp7);
        System.out.println("Employee Set: "+employeeSet);

    }
}
