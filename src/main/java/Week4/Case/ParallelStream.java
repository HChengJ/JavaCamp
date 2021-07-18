package Week4.Case;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(1,10000).forEach(i->list.add(i));
        BlockingQueue<Long> blockingQueue = new LinkedBlockingQueue<>(10000);
        List<Long> longList = list.stream().parallel()
                .map(i->i.longValue())
                .sorted()
                .collect(Collectors.toList());
        //并行
        longList.stream().parallel().forEach(i->{
            try {
                blockingQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("blockingQueue:"+ blockingQueue.toString());
    }
}
