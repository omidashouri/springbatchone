package ir.omidashouri.springbatchone.multithread.threadEssentials;

public class My4CounterExecutor {

    public static void execute(){
        My4Counter my4Counter = new My4Counter(Integer.MAX_VALUE-1);
        synchronized (my4Counter) {
            if (my4Counter.get() < Integer.MAX_VALUE) {
                System.out.println(my4Counter.incrementAndGet());
            } else {
                System.err.println("That would stack over flow");
            }
        }
    }
}
