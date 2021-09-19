package lambdaThread;

public class LambdaThread {

    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(()->{
            for(int i =1;i<=5;i++){
                System.out.println("hi Thread Name: " + Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }
        },"Hi");

        Thread t2 = new Thread(()->{
            for(int i =1;i<=5;i++){
                System.out.println("hello");
                try{
                    Thread.sleep(1000);
                }catch (Exception e){

                }
            }
        });

        System.out.println(Thread.currentThread().getName());
        t2.setName("Hello");
        t1.setPriority(1);
        t2.setPriority(Thread.MAX_PRIORITY);



        System.out.println(t1.getName());
        System.out.println(t1.getPriority());
        // It start the thread and executes the run method which contains business logic
        t1.start();
        t2.start();

        // It causes the current thread(main thread) not to run until t1 finishes execution
        t1.join();
//        t2.join();
        System.out.println("Bye bye");

    }


}
