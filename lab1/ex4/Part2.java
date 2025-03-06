package lab1.ex4;
import java.lang.Thread;
import java.lang.ThreadGroup;

public class Part2 extends Thread{
    int id;

    Part2(ThreadGroup threadGroup, int id){
        super(threadGroup, "Thread "+id);
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
                System.out.printf("Thread %d has been interrupted!\n", this.id);
                return;
            }
        }
        System.out.printf("Thread %d has died\n", this.id);
    }

    public static void main(String[] args){
        ThreadGroup demoGroup = new ThreadGroup("demoGroup");

        Part2 thread1 = new Part2(demoGroup, 1);
        Part2 thread2 = new Part2(demoGroup, 2);
        Part2 thread3 = new Part2(demoGroup, 3);
        Part2 thread4 = new Part2(demoGroup, 4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try{
            sleep(2000);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        demoGroup.interrupt();

    }
}
