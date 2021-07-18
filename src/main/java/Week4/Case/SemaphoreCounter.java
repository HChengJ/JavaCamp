package Week4.Case;

import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SemaphoreCounter {
    private int sum  =0;
    private Semaphore readSemaphore = new Semaphore(100,true);
    private  Semaphore writeSemaphore = new Semaphore(1);
    public int incrAndGet() {
        try {
            writeSemaphore.acquireUninterruptibly();
            int count = ++sum;
            System.out.println("This Thread is write,Thread id = "+Thread.currentThread().getId()+",SemaphoreCounter-incrAndGet-sum="+count);
            return count;
        } finally {
            writeSemaphore.release();
        }
    }
    public  int getSum(){
        try {
            readSemaphore.acquireUninterruptibly();
            System.out.println("This Thread is read,Thread id = "+Thread.currentThread().getId()+",SemaphoreCounter-incrAndGet-sum="+sum);
            return sum;
        }finally {
            readSemaphore.release();
        }
    }

    public static void main(String[] args) {
        int loopNum = 100_0000;
        SemaphoreCounter counter = new SemaphoreCounter();
        IntStream.range(0,loopNum).parallel()
                .forEach(i-> counter.incrAndGet());
    }

}
