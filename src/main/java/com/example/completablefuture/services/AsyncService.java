package com.example.completablefuture.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {
    @Async
    public void asyncMethod() {
        boolean isSaved = false;
        try {
            TimeUnit.SECONDS.sleep(10);
            isSaved = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("asyncMethod done... " + isSaved);
    }
}
