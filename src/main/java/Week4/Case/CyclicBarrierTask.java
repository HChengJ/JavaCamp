package Week4.Case;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTask implements Runnable{
    private CyclicBarrier barrier;
    public CyclicBarrierTask(CyclicBarrier barrier){
        this.barrier = barrier;
    }

    @Override
    public void run() {
        Integer millis = new Random().nextInt(100);
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
            this.barrier.await();//线程阻塞
            System.out.println("开吃："+Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(millis);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int num = 3;
        CyclicBarrier barrier = new CyclicBarrier(num);
        List<CompletableFuture> list = new ArrayList<>(num);
        for(int i = 0; i < num ;i++){
            CompletableFuture<Void> future = CompletableFuture.runAsync(new CyclicBarrierTask(barrier));
//            new Thread(new CyclicBarrierTask(barrier)).start();
            System.out.println("执行次数="+i);
            list.add(future);
        }
        for(CompletableFuture future : list){
            future.get();
        }
        barrier.reset();


    }
}

