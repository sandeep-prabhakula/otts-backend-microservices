package com.sandeepprabhakula.purchasesservice.controller;

import com.sandeepprabhakula.purchasesservice.entities.Purchase;
import com.sandeepprabhakula.purchasesservice.service.PurchaseServiceImpl;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchases/")
public class PurchaseController {
    private final PurchaseServiceImpl purchaseService;

    @CircuitBreaker(name = "SUBSCRIPTION_BREAKER", fallbackMethod = "subscriptionFallback")
    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase){
        return purchaseService.createPurchase(purchase);
    }
    @GetMapping("/get-purchases-uid/{uid}")
    public List<Purchase> getAllPurchasesByUid(@PathVariable("uid") String uid){
        return purchaseService.getAllPurchasesOfUser(uid);
    }
    @GetMapping("/purchase/{pid}")
    public Purchase getPurchaseById(@PathVariable("pid")String pid){
        return purchaseService.getPurchaseById(pid);
    }

    public Purchase subscriptionFallback(Purchase purchase,Exception ex){
        System.out.println("Fallback executed service down : " + ex.getMessage());
        Purchase p = Purchase.builder()
                .subscriptionId("dummyid")
                .purchaseId("dummy id")
                .consumerUid("dummy id")
                .build();
        return p;
    }
}
