package com.sandeepprabhakula.userservice.external.services;

import com.sandeepprabhakula.userservice.entities.Subscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "SUBSCRIPTION-SERVICE")
public interface SubscriptionService {
    @PostMapping("/subscriptions")
    Subscription createSubscription(@RequestBody Subscription subscription);
    @GetMapping("/subscriptions/get-by-ott-name/{ottName}")
    List<Subscription> getSubscriptionsByOttName(@PathVariable("ottName") String ottName);
    @GetMapping("/subscriptions/get-by-uid/{uid}")
    List<Subscription> getSubscriptionsByUid(@PathVariable("uid")String uid);
    @GetMapping("/subscriptions/subscription/{sid}")
    Subscription getSubscriptionById(@PathVariable("sid")String sid);
}
