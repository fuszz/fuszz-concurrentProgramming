package lab1.ex3;
import java.lang.Thread;

public class Subtask1 extends Thread {
    int start, stop;
    Subtask1(int start, int stop){
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
        Subtask1 thread1 = new Subtask1(1, 33);
        Subtask1 thread2 = new Subtask1(50, 88);
        Subtask1 thread3 = new Subtask1(100, 130);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
