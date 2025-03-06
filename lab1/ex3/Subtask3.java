package lab1.ex3;
import java.lang.Thread;

public class Subtask3 extends Thread {
    int start, stop;
    Subtask3(int start, int stop){
        this.start = start;
        this.stop = stop;
    }
    @Override
    public void run(){
        for(int i = start; i <= stop; i++){
            System.out.println(i);
            Thread.yield();
        }
    }

    public static void main (String[] args){
        Subtask3 thread1 = new Subtask3(1, 33);
        Subtask3 thread2 = new Subtask3(50, 88);
        Subtask3 thread3 = new Subtask3(100, 130);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
