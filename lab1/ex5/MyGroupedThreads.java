package lab1.ex5;
import java.lang.ThreadGroup;

public class MyGroupedThreads extends Thread {
    int id;
    MyGroupedThreads(ThreadGroup tg, int id){
        super(tg, String.valueOf(id));
        this.id = id;
    }

    @Override
    public void run(){
        System.out.printf("Hello from the %d thread", this.id);
        try{
            sleep(1000);
        } catch (InterruptedException e){
            return;
        }
        System.out.printf("Goodbye from the %d thread", this.id);
    }

    public static void main(String[] args){
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup");

        MyGroupedThreads thread1 = new MyGroupedThreads(myThreadGroup, 1);
        MyGroupedThreads thread2 = new MyGroupedThreads(myThreadGroup, 2);
        MyGroupedThreads thread3 = new MyGroupedThreads(myThreadGroup, 3);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Current amount of active threads: " + myThreadGroup.activeGroupCount());
        myThreadGroup.list();
        myThreadGroup.interrupt();

        try{
            sleep(3000);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("All threads interrupted");
    }
}
