package ir.omidashouri.springbatchone.multithread.threadEssentials;


public class My4Counter {
    private int value;

    public My4Counter(int value) {
        if (value < 0) {
            throw new ArithmeticException("over flow");
        }
        this.value = value;
    }

    public synchronized int incrementAndGet() {
        if (value == Integer.MAX_VALUE) {
            throw new ArithmeticException("over flow");
        }
        return ++value;
    }

    public synchronized int getAndIncrement() {
        if (value == Integer.MAX_VALUE) {
            throw new ArithmeticException("over flow");
        }
        return value++;
    }

    public synchronized int get() {
        return value;
    }
}
