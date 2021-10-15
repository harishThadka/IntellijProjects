package threadConcepts.runnableDemo;

public class Hi implements Runnable{

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
