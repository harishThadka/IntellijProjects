package threadConcepts.threadDemo;






public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread hi = new Hi();
        Hello hello = new Hello();

//        System.out.println(hi.getName());
        hi.start();
//        Thread.sleep(10);
        hello.start();
    }
}
