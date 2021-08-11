package concepts;

public class Serialization {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.id = 10;
        p1.firstName ="Harish";
        System.out.println(p1);

        Person p2 = p1;
        System.out.println("P1: "+p1.toString()+ " p2: "+p2.toString());
        p2.id = 20;
        p2.firstName ="Sushma";
        System.out.println("P1: "+p1.toString()+ " p2: "+p2.toString());

    }



}

class Person{

    int id;
    String firstName;

    public String toString(){
        return "Id: "+ id +" firstName: "+firstName;
    }
}

