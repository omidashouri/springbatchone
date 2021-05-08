package ir.omidashouri.springbatchone.multithread.threadEssentials;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

public class My4CounterVarHandler {
    private volatile int value;
    private final static VarHandle VALUE;

    static {
        try {
            VALUE = MethodHandles.lookup().findStaticVarHandle(
                    My4CounterVarHandler.class, "value", int.class
            );
        } catch (ReflectiveOperationException e) {
            throw new Error(e);
        }
    }

    public My4CounterVarHandler(int value) {
        if (value < 0) {
            throw new ArithmeticException("over flow");
        }
        this.value = value;
    }

    public int incrementAndGet() {
        return getAndIncrement() + 1;
    }

    public synchronized int getAndIncrement() {
        int current;
        do {
            current = value;
            if (current == Integer.MAX_VALUE) {
                throw new ArithmeticException("over flow");
            }
        } while (!VALUE.compareAndSet(this, current, current + 1));
        return current;
    }

    public boolean safeIncrement(){
        int current;
        do {
            current = value;
            if (current == Integer.MAX_VALUE) {
                return false;
            }
        } while (!VALUE.compareAndSet(this, current, current + 1));
        return true;
    }

    public synchronized int get() {
        return value;
    }
}
