package org.example.counter;

public class Counter implements Runnable{
    private int count = 0;
    public void increment() {
        count ++;
    }
    public void decrement() {
        count --;
    }

    public int getValue() {
        return count;
    }

    @Override
    public void run() {
        synchronized (this) {
            this.increment();
            System.out.print("Value for thread After increment ");
            System.out.println(getValue());
            this.decrement();
            System.out.print("Value for thread after decrement ");
            System.out.println(getValue());
        }
    }
}
