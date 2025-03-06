package lab1.ex2;
import java.lang.Runnable;

public class RunnableImplementation implements Runnable{
    int number;
    RunnableImplementation(int number){
        this.number = number;
    }
    public void run(){
        System.out.println(this.number + " Hello world!");
    }

    public static void main (String[] args){
        for(int i=0; i<5; i++){
            RunnableImplementation runnable = new RunnableImplementation(i);
            new Thread(runnable).start();
        }
    }
}
