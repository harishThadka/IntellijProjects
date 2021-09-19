package threadDemo;


class Hi extends Thread{

    @Override
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

class Hello extends Thread{

    @Override
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
