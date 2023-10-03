package com.sandeepprabhakula.userservice.external.services;

import com.sandeepprabhakula.userservice.entities.Purchase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PURCHASES-SERVICE")
public interface PurchaseService {

    @GetMapping("/purchases/get-purchases-uid/{uid}")
    List<Purchase> getAllPurchasesByUid(@PathVariable("uid") String uid);
}
