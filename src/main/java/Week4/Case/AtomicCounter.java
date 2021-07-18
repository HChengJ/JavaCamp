package Week4.Case;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger sum = new AtomicInteger(0);

    public int incrAndGet() {
        int count = sum.incrementAndGet();
        System.out.println("this thread id=" + Thread.currentThread().getId() + ",AtomicCounter-incrAndGet-sum=" + count);
        return count;
    }

    public int getSum() {
        int count1 = sum.get();
        System.out.println("this thread id=" + Thread.currentThread().getId() + ",AtomicCounter-getSum-sum=" + count1);
        return count1;
    }
    public static void main(String[] args) {
        AtomicCounter atomicCounter = new AtomicCounter();
        atomicCounter.incrAndGet();
    }

}
