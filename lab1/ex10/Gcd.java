package lab1.ex10;
import java.lang.Thread;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Slave extends Thread{
    int a, b;
    int[] numbers;

    Slave(int a, int b, int[] numbers){
        this.a = a;
        this.b = b;
        this.numbers = numbers;
    }

    static int euclidean(int a, int b){
        while(b != 0){
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    @Override
    public void run(){
        int gcd = Slave.euclidean(numbers[a], numbers[b]);
//        System.out.printf("\na = %d, b = %d, gcd = %d\n", numbers[a], numbers[b], gcd);
        this.numbers[a] = gcd;
        this.numbers[b] = gcd;
    }
}


class Master extends Thread{

    int[] numbers;
    int length;

    Master(int[] numbers, int length) {
        this.numbers = numbers;
        this.length = length;

    }
    @Override
    public void run(){

        if(length == 1){
            return;
        }

        if(length == 2){
            Slave s = new Slave(0, 1, numbers);
            return;
        }

        int x = 0;
        int y = this.length - 1;

        while(y - x > 2){
            Slave left = new Slave(x, x+1, numbers);
            Slave right = new Slave(y-1, y, numbers);

            left.start();
            right.start();
            try{
                left.join();
                right.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
//            System.out.println("x=" + String.valueOf(x) + ", y=" + String.valueOf(y) + Arrays.toString(numbers));
            x++;
            y--;
        }

        while(x != y){
            Slave left = new Slave(x, x+1, numbers);
            left.start();
            try{ left.join(); } catch (InterruptedException e) { System.out.println(e.getMessage()); }

//            System.out.println("x=" + String.valueOf(x) + ", y=" + String.valueOf(y) + Arrays.toString(numbers));
            x++;
        }

        numbers[0] = numbers[x-1];
    }
}


public class Gcd {

    public static int gcd(int[] numbers){
        Master master = new Master(numbers, numbers.length);
        master.start();
        try{
            master.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return numbers[0];
    }

    public static void main(String[] args){
        int[] numbers = {40, 10, 100, 200, 80};
        System.out.println(Arrays.toString(numbers) + ": GCD = " + Gcd.gcd(numbers));

        int[] numbers1 = {10, 100, 200, 80};
        System.out.println(Arrays.toString(numbers1) + ": GCD = " + Gcd.gcd(numbers1));

        int[] numbers2 = {7, 8, 1, 2, 80};
        System.out.println(Arrays.toString(numbers2) + ": GCD = " + Gcd.gcd(numbers2));

        int[] numbers3 = {21, 3, 6, 15, 18};
        System.out.println(Arrays.toString(numbers3) + ": GCD = " + Gcd.gcd(numbers3));
    }
}
