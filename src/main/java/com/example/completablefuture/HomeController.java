package com.example.completablefuture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getAsync() {
        String result = "no-data";

        try {
            TimeUnit.SECONDS.sleep(1);
            result = "Got response";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        allContentsFuture();

        return result;
    }

    public void allContentsFuture(){
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
            System.out.println("All contents saved " + result);
        });
    }
}
