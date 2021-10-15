package collectionPackage;

import java.util.Objects;

public class Employee {

    private long id;
    private  String name;
    static String company;

    static {
//        System.out.println("Static Block");
        company="Google";
    }
    public Employee(){

    }

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void displayStatic(){
        System.out.println("Static Method");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printThis(){
        System.out.println("This reference"+this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "To String: Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}