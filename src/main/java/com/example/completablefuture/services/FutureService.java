package com.example.completablefuture.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class FutureService {

    public void futureMethod(){
        CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running Job
            boolean isSaved = false;
            try {
                TimeUnit.SECONDS.sleep(10);
                isSaved = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return isSaved;
        }).thenAccept(result -> {
            System.out.println("futureMethod done... " + result);
        });
    }
}
