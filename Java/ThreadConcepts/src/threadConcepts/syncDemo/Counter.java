package threadConcepts.syncDemo;

public class Counter{

    int count;

    public synchronized void increment(){
        count++;
    }
}
