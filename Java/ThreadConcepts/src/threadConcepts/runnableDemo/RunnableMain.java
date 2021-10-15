package threadConcepts.runnableDemo;






public class RunnableMain {

    public static void main(String[] args) {

        Hi hi = new Hi();
        Hello hello = new Hello();

        Thread t1 = new Thread(hi);
        System.out.println(t1.getName());
        Thread t2 = new Thread(hello);
        System.out.println(t2.getName());

        t1.start();
        t2.start();

    }
}
