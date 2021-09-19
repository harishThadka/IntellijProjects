package runnableDemo;


class Hi implements Runnable{

    public void run(){

        for (int i=1;i<=5;i++){
            System.out.println("Hi");
            try{
                Thread.sleep(1000);

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }
}

class Hello implements Runnable{


    public void run(){

        for (int i=1;i<=5;i++){
            System.out.println("Hello");
            try{
                Thread.sleep(1000);

            }catch (Exception e){
                System.out.println(e);
            }
        }

    }
}

public class RunnableDemo{

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
