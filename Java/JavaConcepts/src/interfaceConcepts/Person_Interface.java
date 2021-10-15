package interfaceConcepts;

public interface Person_Interface {

    int var = 0;

    void walk();

    default void print(){
        System.out.println("Person Interface");
    }

}
