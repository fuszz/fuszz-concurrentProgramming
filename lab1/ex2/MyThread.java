package lab1.ex2;
import java.lang.Thread;
import java.util.Arrays;

public class MyThread extends Thread{
    int number;

    MyThread(int number){
        this.number = number;
    }

    @Override
    public void run(){
        System.out.println(this.number + ", Hello world!");
    }
    public static void main (String [] args){
        for(int i=0; i < 5; i++){
            MyThread someThread = new MyThread(i);
            someThread.start();
        }
    }
}