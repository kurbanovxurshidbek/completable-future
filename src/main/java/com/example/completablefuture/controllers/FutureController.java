package com.example.completablefuture.controllers;

import com.example.completablefuture.services.FutureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FutureController {
    @Autowired
    FutureService futureService;

    @GetMapping("/future")
    public String getFuture() {
        long start = System.currentTimeMillis();
        String response = "no-data";

        try {
            TimeUnit.SECONDS.sleep(1);
            response = "Future task completes in :" + (start -   System.currentTimeMillis()) + "milliseconds";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        futureService.futureMethod();

        return response;
    }


}
