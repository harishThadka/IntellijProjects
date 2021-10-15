package threadConcepts.DaemonDemo;

public class ThreadClass extends Thread{


    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("Execution in child thread: "+i);
            System.out.println("Daemon Thread: "+Thread.currentThread().isDaemon());
        }
    }
}
