package com.example.completablefuture.controllers;

import com.example.completablefuture.services.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

@RestController
@EnableAsync
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("/async")
    public String asyncCallerMethod() {
        long start = System.currentTimeMillis();
        String response = "no-data";

        try {
            TimeUnit.SECONDS.sleep(1);
            response = "Async task completes in :" + (start -   System.currentTimeMillis()) + "milliseconds";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        asyncService.asyncMethod();

        return response;
    }
}
