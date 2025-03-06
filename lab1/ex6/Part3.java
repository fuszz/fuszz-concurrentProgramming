package lab1.ex6;
import java.lang.Thread;

public class Part3 extends Thread {
    int id;
    Part3(int id){
        this.id = id;
    }
    @Override
    public void run(){
        for(int i=0; i<100; i++){
            System.out.printf("Thread no. %d\n", this.id);
        }
    }


    public static void main(String[] args){
        Part3 thread1 = new Part3(1);
        Part3 thread2 = new Part3(2);

        thread1.start();
        thread2.start();
    }

}
