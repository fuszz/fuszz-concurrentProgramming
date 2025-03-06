package lab1.ex6;
import java.lang.Thread;

public class Part2 extends Thread {
    int id;
    Part2(int id){
        this.id = id;
    }
    @Override
    public void run(){
        while(true){
        System.out.printf("Thread no. %d\n", this.id);
        }
    }


    public static void main(String[] args){
        Part2 thread1 = new Part2(1);
        Part2 thread2 = new Part2(2);

        thread1.start();
        thread2.start();
    }

}
