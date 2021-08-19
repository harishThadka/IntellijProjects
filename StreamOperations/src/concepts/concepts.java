package concepts;



public class concepts {

    public static void main(String[] args) {

        // Primitive data types memory location check:
        int d1 = 30;
        int d2 = 30;

        System.out.println("d1 identity hashcode: "+System.identityHashCode(d1));
        System.out.println("d2 identity hashcode: "+System.identityHashCode(d1));

        System.out.println("-------------------------------------------");
        // String is immutable Object whereas String builder is mutable object
        String s = "Hello"; // Using String literal,  Object will create in string pool
        String s1 = "Hello"; // First it checks whether it present in String Pool if yes then reference to that string
        String s2 = new String("Hello"); // Using new Keyword, new String object will be created in heap memory
        String s3 = new String("Hello");

        // IdentityHashCode object is guaranteed to never change for the lifetime of the object
        //https://stackoverflow.com/questions/4930781/how-do-hashcode-and-identityhashcode-work-at-the-back-end
        System.out.println("s identity hashcode:"+System.identityHashCode(s));
        System.out.println("s1 identity hashcode:"+System.identityHashCode(s1));
        System.out.println("s2 identity hashcode:"+System.identityHashCode(s2));
        System.out.println("s3 identity hashcode:"+System.identityHashCode(s3));
        System.out.println("s hashcode: "+s.hashCode());
        System.out.println("s1 hashcode: "+s1.hashCode());
        System.out.println("s2 hashcode: "+s2.hashCode());
        System.out.println("s3 hashcode: "+s3.hashCode());


        System.out.println("s == s1 "+ (s == s1));
        System.out.println("s == s2 "+(s == s2));
        System.out.println("-------------------------------------------");


        System.out.println("Equals method: "+s.equals(s2));
        System.out.println("== "+s==s2);

        s += "This is String";
        System.out.println(s+" hashcode:"+s.hashCode());


        StringBuilder sb = new StringBuilder("Hi");
        s.equals(sb);
        System.out.println(sb+" hashcode:"+sb.hashCode());
        sb.append("This is String Builder");
        System.out.println(sb+" hashcode:"+sb.hashCode());

        StringBuffer st = new StringBuffer("Hi");
        System.out.println(st+" hashcode:"+st.hashCode());
        sb.append("This is String Buffer");
        System.out.println(st+" hashcode:"+st.hashCode());

    }
}
