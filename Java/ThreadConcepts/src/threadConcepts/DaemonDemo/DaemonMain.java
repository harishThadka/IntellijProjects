package threadConcepts.DaemonDemo;

public class DaemonMain {

    public static void main(String[] args) {

        ThreadClass threadClass = new ThreadClass();
        threadClass.setDaemon(true);
        threadClass.start();
//        System.out.println("***********"+threadClass.getState());

        for (int i=0;i<1000;i++){
            System.out.println("Execution in Main Thread");
        }
    }
}
