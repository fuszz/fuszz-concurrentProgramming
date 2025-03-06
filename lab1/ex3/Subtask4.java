package lab1.ex3;
import java.lang.Thread;

public class Subtask4 extends Thread {
    int start, stop;
    Subtask4(int start, int stop){
        this.start = start;
        this.stop = stop;
    }
    @Override
    public void run(){
        for(int i = start; i <= stop; i++){
            System.out.println(i);
            Thread.yield();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main (String[] args){
        Subtask4 thread1 = new Subtask4(1, 33);
        Subtask4 thread2 = new Subtask4(50, 88);
        Subtask4 thread3 = new Subtask4(100, 130);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
