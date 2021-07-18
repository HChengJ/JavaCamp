package Week4.Case;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class LockCounter {
    private int sum=0;
    //可重入锁+公平锁
    private Lock lock = new ReentrantLock(true);
    public int addAndGet(){
        try {
            lock.lock();

            Thread thread = Thread.currentThread();
            long threadId = thread.getId();
            int i = ++sum;
            System.out.println("this threadId="+threadId+",addAndGet return:"+i);
            getSum();
            return i;
        }finally {
            lock.unlock();
        }
    }
    public int getSum(){
        System.out.println("getsum:"+sum);
        return sum;
    }

    public static void main(String[] args) {
        int loopNum = 100_0000;
        /*LockCounter counter = new LockCounter();
        IntStream.range(0,loopNum).parallel()
                .forEach(i-> counter.addAndGet());*/
       /* ReadWriteLockCounter counter = new ReadWriteLockCounter();
        IntStream.range(0,loopNum).parallel()
                .forEach(i-> counter.getSum());*/
        ReadWriteLockCounter counter = new ReadWriteLockCounter();
        IntStream.range(0,loopNum).parallel()
                .forEach(i-> counter.incrAndGet());
    }

}
