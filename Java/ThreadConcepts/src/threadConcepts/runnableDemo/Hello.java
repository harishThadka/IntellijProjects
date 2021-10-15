package threadConcepts.runnableDemo;

public class Hello implements Runnable{


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