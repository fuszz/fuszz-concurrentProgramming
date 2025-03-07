package lab1.ex11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class OddThread extends Thread {
    BlockingQueue<Integer> box;
    int current_number = 1;

    OddThread(BlockingQueue box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            try {
                box.put(current_number);
                System.out.println("Przekazałem liczbę " + current_number);
                this.current_number += 2;
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class EvenThread extends Thread {
    BlockingQueue<Integer> box;
    int current_number = 2;

    EvenThread(BlockingQueue box) {
        this.box = box;
    }

    @Override
    public void run() {
        while (true) {
            try {
                box.put(current_number);
                System.out.println("Przekazałem liczbę " + current_number);
                this.current_number += 2;
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class ReceivingThread extends Thread {
    BlockingQueue<Integer> evenBox = new ArrayBlockingQueue<>(1);
    BlockingQueue<Integer> oddBox = new ArrayBlockingQueue<>(1);

    @Override
    public void run() {
        EvenThread even = new EvenThread(evenBox);
        OddThread odd = new OddThread(oddBox);

        even.start();
        odd.start();

        while (true) {
            try {
                System.out.println("Większą liczbą jest " + Math.max(evenBox.take(), oddBox.take()));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class EvenAndOdd {
    public static void main(String[] args) {
        ReceivingThread rt = new ReceivingThread();
        rt.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}