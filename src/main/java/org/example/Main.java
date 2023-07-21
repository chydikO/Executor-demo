package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        //Example_1_OneThread();
        Example_2_TwoThread();
    }

    private static void Example_1_OneThread() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        });

        executorService.submit(() -> {
            for (int i = 100; i < 110; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        });
        executorService.shutdown();
    }

    private static void Example_2_TwoThread() {
        //фиксированное число потоков -2
        //ExecutorService executorService = Executors.newFixedThreadPool(2);

        //используются все доступные потоки
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        });

        executorService.submit(() -> {
            for (int i = 100; i < 110; i++) {
                System.out.println(i + " " + Thread.currentThread().getName());
            }
        });
        executorService.shutdown();
    }
}