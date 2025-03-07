package lab1.ex8;

public class Licznik extends Thread {
    private int value = 0;
    private boolean increments;
    private int razy;
    private Licznik licznik;

    public Licznik(Licznik licznik, boolean increments, int razy) {
        this.licznik = licznik;
        this.increments = increments;
        this.razy = razy;
    }

    public Licznik() {}

    @Override
    public void run() {
        for (int i = 0; i < razy; i++) {
            if (increments) {
                licznik.inc();
            } else {
                licznik.dec();
            }
        }
    }

    public synchronized void inc() {
        value++;
    }

    public synchronized void dec() {
        value--;
    }

    public synchronized int get() {
        return value;
    }

    public static void main(String[] args) {
        Licznik licznik = new Licznik();

        Thread t1 = new Licznik(licznik, true, 10000);
        Thread t2 = new Licznik(licznik, false, 5000);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Końcowa wartość licznika: " + licznik.get());
    }
}
