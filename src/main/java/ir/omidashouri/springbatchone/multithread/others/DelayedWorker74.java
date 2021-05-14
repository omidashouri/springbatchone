package ir.omidashouri.springbatchone.multithread.others;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
public class DelayedWorker74 implements Delayed {

    private long duration;
    private String message;

    public DelayedWorker74(long duration, String message) {
        this.duration = System.currentTimeMillis()+duration;
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed otherDelay) {
        if (this.duration < ((DelayedWorker74) otherDelay).getDuration()) {
            return -1;
        }
        if (this.duration > ((DelayedWorker74) otherDelay).getDuration()) {
            return +1;
        }
        return 0;
    }
}
