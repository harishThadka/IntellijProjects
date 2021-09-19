package interfaceConcepts;

public interface Person_Interface {

    void walk();

    default void print(){
        System.out.println("Person Interface");
    }

}
