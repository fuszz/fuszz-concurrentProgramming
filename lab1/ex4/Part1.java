package lab1.ex4;
import java.lang.Thread;

public class Part1 extends Thread{
    int id;

    Part1(int id){
        this.id = id;
    }

    @Override
    public void run(){
        System.out.printf("Thread %d is beginning\n", this.id);
        for(int i=0; i<5; i++){
            System.out.printf("Thread %d - %d\n", this.id, i);
            try{
                sleep(1000);
            } catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.printf("Thread %d has died\n", this.id);
    }

    public static void main(String[] args){
        Part1 thread1 = new Part1(1);
        Part1 thread2 = new Part1(2);
        Part1 thread3 = new Part1(3);
        Part1 thread4 = new Part1(4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
