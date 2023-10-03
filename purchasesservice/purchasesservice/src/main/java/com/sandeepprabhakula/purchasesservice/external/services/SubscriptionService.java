package com.sandeepprabhakula.purchasesservice.external.services;

import com.sandeepprabhakula.purchasesservice.entities.Subscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "SUBSCRIPTION-SERVICE")
public interface SubscriptionService {
    @GetMapping("/subscriptions/subscription/{sid}")
    Subscription getSubscriptionById(@PathVariable("sid")String sid);
    @PutMapping("/subscriptions/update")
    Subscription updateSlotsOfSubscription(@RequestBody Subscription subscription);
}
