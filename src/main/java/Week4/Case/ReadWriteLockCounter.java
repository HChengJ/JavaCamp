package Week4.Case;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockCounter {

    private int sum = 0;
    //可重入-读写锁-公平锁
    private ReadWriteLock lock = new ReentrantReadWriteLock(true);
    public int incrAndGet(){
        try {
            long threadId = Thread.currentThread().getId();
            lock.writeLock().lock();//写锁，独占锁，被读锁排斥
            int count = ++sum;
            System.out.println("this Thread is writeLock,id = "+threadId+"|incrAndGet-sum="+count);
            return  count;
        }finally {
            lock.writeLock().unlock();
        }

    }
    public int getSum(){
        try {
            lock.readLock().lock();//读锁；共享锁；
            int count1 = ++sum;
            System.out.println("this Thread is readLock,Thread id = "+ Thread.currentThread().getId()+",getSum-sum="+count1);
            return  count1;
        }finally {
            lock.readLock().unlock();
        }
    }

}
