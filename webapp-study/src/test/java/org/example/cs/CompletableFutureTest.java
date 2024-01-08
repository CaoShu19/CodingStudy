package org.example.cs;

import org.example.Main;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Str2ke
 * @date : 2024/1/4 上午1:17
 * @Desc :
 */


public class CompletableFutureTest {
    private static ExecutorService executorService;
    static{
        executorService = Executors.
                newFixedThreadPool(
                        Runtime.getRuntime().availableProcessors(),
                        t -> {
                            Thread thread = new Thread(t);
                            thread.setName("the pool ...");
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
        CompletableFuture.supplyAsync(()->this.getName("ddd"))
                .thenApplyAsync((a)-> {
                    System.out.println(a);
                    return a;
                });
    }


}
