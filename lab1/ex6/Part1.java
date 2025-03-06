package lab1.ex6;
import java.lang.Thread;

public class Part1 extends Thread {
    int id;
    Part1(int id){
        this.id = id;
    }
    @Override
    public void run(){
        System.out.printf("Thread no. %d\n", this.id);
    }

    public static void main(String[] args){
        Part1 thread1 = new Part1(1);
        Part1 thread2 = new Part1(2);

        thread1.start();
        thread2.start();
    }
}
