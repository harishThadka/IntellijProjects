package Operations;

public class PassByValue {

    public static void main(String[] args) {
            Dog aDog = new Dog("Max");
            Dog oldDog = aDog;

            foo(aDog);
            // when foo(...) returns, the name of the dog has been changed to "Fifi"
            // true
        System.out.println( aDog.getName().equals("Fifi"));
            // but it is still the same dog:
//            aDog == oldDog; // true
        System.out.println(aDog.equals(oldDog));
        }

        public static void foo(Dog d) {
            d.getName().equals("Max"); // true
            // this changes the name of d to be "Fifi"
            d.setName("Fifi");
    }
}
