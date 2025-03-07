package lab1.ex7;
import java.lang.Thread;
import java.util.Random;

class Thread1 extends Thread{
    @Override
    public void run(){
        Random random = new Random();
        while(true){
            double avg = 0;
            for(int i=0; i<100; i++){
                avg += random.nextInt(100);
            }
            System.out.println("Thread 1: " + String.valueOf(avg/100));
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run(){
        Random random = new Random();
        while(true){
            double avg = 0;
            for(int i=0; i<30; i++){
                avg += Math.log(random.nextInt(100));
            }
            System.out.println("Thread 2: " + String.valueOf(Math.exp(avg/30)));
        }
    }
}

class Thread3 extends Thread{
    @Override
    public void run(){
        Random random = new Random();
        while(true){
            double avg = 0;
            System.out.println("Thread 3: " + String.valueOf(Math.log(Math.pow(random.nextInt(41)-20, 2))));
        }
    }
}

public class Main {

    public static void main (String[] args){
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        Thread3 t3 = new Thread3();

        t1.start();
        t2.start();
        t3.start();

    }
}
