package lab1.ex9;
import java.lang.Thread;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MultipleThreads{
    BlockingQueue<Integer> number = new ArrayBlockingQueue<>(1);

    public Integer getNumber() throws InterruptedException {
        return number.take();
    }

    public void setNumber(Integer number) throws InterruptedException {
        this.number.put(number);
    }

    public static void main(String[] args){
        MultipleThreads box = new MultipleThreads();

        Thread thread1 = new Thread(() -> {
           Random random = new Random();
           Integer a = random.nextInt();
           System.out.println("Thread 1 - generated " + String.valueOf(a));
           try{
               box.setNumber(a);
           } catch(InterruptedException e){
               System.out.println(e.getMessage());
           }
        });

        Thread thread2 = new Thread(() -> {
            try{
                box.setNumber(box.getNumber() + 2);
            } catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        });

        Thread thread3 = new Thread(() -> {
            try{
                System.out.println("Thread 3 - got " + String.valueOf(box.getNumber()));
            } catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
