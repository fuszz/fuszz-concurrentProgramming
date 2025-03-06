package lab1.ex3;
import java.lang.Thread;

public class Subtask2 extends Thread {
    int start, stop;
    Subtask2(int start, int stop){
        this.start = start;
        this.stop = stop;
    }
    @Override
    public void run(){
        for(int i = start; i <= stop; i++){
            System.out.println(i);
        }
    }

    public static void main (String[] args){
        Subtask2 thread1 = new Subtask2(1, 33);
        Subtask2 thread2 = new Subtask2(50, 88);
        Subtask2 thread3 = new Subtask2(100, 130);

        try{
            thread1.start();
            thread1.join();

            thread2.start();
            thread2.join();

            thread3.start();
            thread3.join();
        } catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
}
