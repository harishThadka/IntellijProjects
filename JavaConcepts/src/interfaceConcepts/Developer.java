package interfaceConcepts;

public class Developer implements Employee_Interface{

    int id = 111;
    String name = "developer";

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }


    public void print(){
        System.out.println("Developer Class");
        // Access super method:
        Employee_Interface.super.print();

    }

    public static void staticPrint(){
        System.out.println("Static Developer Class");
    }
}
