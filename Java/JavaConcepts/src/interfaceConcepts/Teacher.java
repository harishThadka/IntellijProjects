package interfaceConcepts;

public class Teacher implements Employee_Interface,Person_Interface{


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void print() {
        Person_Interface.super.print();
    }

    @Override
    public void walk() {
        System.out.println("Walking");
    }
}
