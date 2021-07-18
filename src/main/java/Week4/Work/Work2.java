package Week4.Work;

import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Work2 {
    /**
     * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
     * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
     * 写出你的方法，越多越好，提交到github。
     *
     * 一个简单的代码参考：
     */
    public static void main(String[] args) {

        long start=System.currentTimeMillis();
        // 在这里创建一个线程或线程池，
        int result = sum(); //这是得到的返回值
        // 确保  拿到result 并输出
        System.out.println("同步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程

        // 异步方法一：
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start1=System.currentTimeMillis();
                int result1 = sum();
                System.out.println("异步方法一计算结果为："+result1);
                System.out.println("异步方法一使用时间："+ (System.currentTimeMillis()-start1) + " ms");
            }
        }).start();
        // 异步方法二：
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                long start2=System.currentTimeMillis();
                int result2 = sum();
                System.out.println("异步方法二算结果为："+result2);
                System.out.println("异步方法二使用时间："+ (System.currentTimeMillis()-start2) + " ms");
            }
        });
        executorService.shutdown();
        // 异步方法三：
        ExecutorService executorService1 =  Executors.newCachedThreadPool();
        executorService1.execute(new Runnable() {
            @Override
            public void run() {
                long start3=System.currentTimeMillis();
                int result3 = sum();
                System.out.println("异步方法三算结果为："+result3);
                System.out.println("异步方法三使用时间："+ (System.currentTimeMillis()-start3) + " ms");
            }
        });
        executorService1.shutdown();
        // 异步方法四：
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.execute(new Runnable() {
            @Override
            public void run() {
                long start4=System.currentTimeMillis();
                int result4 = sum();
                System.out.println("异步方法四算结果为："+result4);
                System.out.println("异步方法四使用时间："+ (System.currentTimeMillis()-start4) + " ms");
            }
        });
        executorService2.shutdown();

        // 异步方法五：
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(@NonNull final Runnable r) {
                return new Thread() {
                    @Override
                    public void run() {
                        r.run();
                    }
                };
            }
        };
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.schedule(threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                long start5=System.currentTimeMillis();
                int result5 = sum();
                System.out.println("异步方法五结果为："+result5);
                System.out.println("异步方法五使用时间："+ (System.currentTimeMillis()-start5) + " ms");
            }
        }), 1, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();
        // 异步方法六：
        ScheduledExecutorService scheduledExecutorService2 = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService2.schedule(threadFactory.newThread(new Runnable() {
            @Override
            public void run() {
                long start6=System.currentTimeMillis();
                int result6 = sum();
                System.out.println("异步方法六结果为："+result6);
                System.out.println("异步方法六使用时间："+ (System.currentTimeMillis()-start6) + " ms");
            }
        }), 1, TimeUnit.SECONDS);
        scheduledExecutorService2.shutdown();
        // 异步方法七：
        ScheduledExecutorService scheduledExecutorService3 = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService3.execute(new Runnable() {
            @Override
            public void run() {
                long start7=System.currentTimeMillis();
                int result7 = sum();
                System.out.println("异步方法七算结果为："+result7);
                System.out.println("异步方法七使用时间："+ (System.currentTimeMillis()-start7) + " ms");
            }
        });
        scheduledExecutorService3.shutdown();
        // 异步方法八：
        List<Callable> callableList = new ArrayList<>();
        callableList.add(new MyCallable());
        ScheduledExecutorService scheduledExecutorService4 = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService4.schedule(callableList.get(0),1,TimeUnit.SECONDS);
        scheduledExecutorService4.shutdown();
        // 异步方法九：
        ExecutorService executorService5 = Executors.newSingleThreadExecutor(threadFactory);
        executorService5.execute(new Runnable() {
            @Override
            public void run() {
                long start8=System.currentTimeMillis();
                int result8 = sum();
                System.out.println("异步方法九算结果为："+result8);
                System.out.println("异步方法九使用时间："+ (System.currentTimeMillis()-start8) + " ms");
            }
        });
        executorService5.shutdown();
        // 异步方法十：
        ExecutorService executorService6 = Executors.newCachedThreadPool(threadFactory);
        executorService6.execute(new Runnable() {
            @Override
            public void run() {
                long start9=System.currentTimeMillis();
                int result9 = sum();
                System.out.println("异步方法十算结果为："+result9);
                System.out.println("异步方法十使用时间："+ (System.currentTimeMillis()-start9) + " ms");
            }
        });
        executorService6.shutdown();
        // 异步方法十一：
        ExecutorService executorService7 = Executors.newScheduledThreadPool(1,threadFactory);
        executorService7.execute(new Runnable() {
            @Override
            public void run() {
                long start10=System.currentTimeMillis();
                int result10 = sum();
                System.out.println("异步方法十一算结果为："+result10);
                System.out.println("异步方法十一使用时间："+ (System.currentTimeMillis()-start10) + " ms");
            }
        });
        executorService7.shutdown();
        // 异步方法十二：
        ExecutorService executorService8 = Executors.newFixedThreadPool(1,threadFactory);
        executorService8.execute(new Runnable() {
            @Override
            public void run() {
                long start11=System.currentTimeMillis();
                int result11 = sum();
                System.out.println("异步方法十二算结果为："+result11);
                System.out.println("异步方法十二使用时间："+ (System.currentTimeMillis()-start11) + " ms");
            }
        });
        executorService8.shutdown();
        // 异步方法十三：
        ExecutorService executorService9 = Executors.newWorkStealingPool();
        executorService9.execute(new Runnable() {
            @Override
            public void run() {
                long start12=System.currentTimeMillis();
                int result12 = sum();
                System.out.println("异步方法十三算结果为："+result12);
                System.out.println("异步方法十三使用时间："+ (System.currentTimeMillis()-start12) + " ms");
            }
        });
        executorService9.shutdown();
        // 异步方法十四：
        Callable callable1 = Executors.callable(new Runnable() {
            @Override
            public void run() {
                long start13=System.currentTimeMillis();
                int result13 = sum();
                System.out.println("异步方法十四算结果为："+result13);
                System.out.println("异步方法十四使用时间："+ (System.currentTimeMillis()-start13) + " ms");
            }
        });
        try{
            callable1.call();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        // 异步方法十五：
        ExecutorService executorService11 = Executors.newFixedThreadPool(1);
        try{
            Future<Integer> future = (Future<Integer>) executorService11.submit(()->{
                long start14=System.currentTimeMillis();
                int result14 = sum();
                System.out.println("异步方法十五算结果为："+result14);
                System.out.println("异步方法十五使用时间："+ (System.currentTimeMillis()-start14) + " ms");
            });
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        executorService11.shutdown();;
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

}
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        long start7=System.currentTimeMillis();
        int result = sum();
        System.out.println("异步方法八算结果为："+result);
        System.out.println("异步方法八使用时间："+ (System.currentTimeMillis()-start7) + " ms");
        return result;
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}

