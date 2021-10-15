package collectionPackage;

public class EmployeeDemo {

    public static void main(String[] args) {

        Employee.displayStatic();
        Employee employee = new Employee();
//        Employee.company="facebook";
        System.out.println(Employee.company);
        employee.printThis();
        System.out.println(employee.getClass().getName());
        System.out.println(employee.getClass());

    }
}
