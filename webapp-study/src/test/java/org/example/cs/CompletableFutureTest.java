package org.example.cs;

import org.example.Main;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Str2ke
 * @date : 2024/1/4 上午1:17
 * @Desc :
 */

/**
 * JDK1.8 才新加入的一个实现类 CompletableFuture，实现了 Future，CompletionStage两个接口。
 * 实现了 Future 接口，意味着可以像以前一样通过阻塞或者轮询的方式获得结果。
 *
 * CompletableFuture是Future接口的扩展和增强。CompletableFuture实现了Future接口，并在此基础上进行了丰富地扩展，
 * 完美地弥补了Future上述的种种问题。
 * 更为重要的是，CompletableFuture实现了对任务的编排能力。
 * 借助这项能力，我们可以轻松地组织不同任务的运行顺序、规则以及方式。从某种程度上说，这项能力是它的核心能力。
 * 而在以往，虽然通过CountDownLatch等工具类也可以实现任务的编排，但需要复杂的逻辑处理，不仅耗费精力且难以维护。
 */

@SpringBootTest
public class CompletableFutureTest {
    private static ExecutorService executorService;
    static{
        executorService = Executors.
                newFixedThreadPool(
                        Runtime.getRuntime().availableProcessors(),
                        t -> {
                            Thread thread = new Thread(t);
                            System.out.println(thread.getName());
                            return thread;}
                        );
    }

    String getName(String name) {
        System.out.println("=========" + Thread.currentThread().getName());
        return name;
    }

    @Test
    public void demo() throws ExecutionException, InterruptedException {
        // 不带返回值的任务,丢给线程异步执行
        CompletableFuture<Void> a1 = CompletableFuture.runAsync(() -> {
            System.out.println("111");
            this.getName("aaa");
        }, executorService);

        //带返回值的任务,丢给线程异步执行
        CompletableFuture<String> b1 = CompletableFuture.supplyAsync(() ->
                this.getName("bbb"), executorService);

        System.out.println(a1.get());
        System.out.println(b1.get());
        System.out.println(b1.join());//若有异常抛出未检查的异常

        // 链式写法表示执行完继续执行第二个任务,同时第一个任务返回值作为第二个任务的参数,第二个任务无返回
        CompletableFuture.supplyAsync(()->this.getName("ccc"))
                .thenAccept(System.out::println);
// 链式写法表示执行完继续执行第二个任务,同时第一个任务返回值作为第二个任务的参数,第二个任务有返回
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> this.getName("ddd"))
                .thenApplyAsync((a) -> {
                    System.out.println(a);
                    return a;
                });
        String s = future.get();
        System.out.println(s);

        // 工作中常见任务流:1.知道多少任务
        CompletableFuture<Void> a = CompletableFuture.supplyAsync(() -> {
            System.out.println("a");
            return "b";
        }).thenApply((x) -> {
            System.out.println(x);
            return "c";
        }).thenAcceptAsync(System.out::println);
        CompletableFuture<Void> b = CompletableFuture.supplyAsync(() -> {
            System.out.println("d");
            return "e";
        }).thenApply((x) -> {
            System.out.println(x);
            return "f";
        }).thenAcceptAsync(System.out::println);
        Void join = CompletableFuture.allOf(a, b).join();

        // 2. 不知道多少任务
        List<String> ss = new ArrayList<>(4);
        ss.addAll(Arrays.asList("1","2","3","4"));
        List<CompletableFuture> cc = new ArrayList<>();


    }


}
