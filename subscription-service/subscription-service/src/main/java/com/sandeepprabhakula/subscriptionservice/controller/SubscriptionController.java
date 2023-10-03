package com.sandeepprabhakula.subscriptionservice.controller;

import com.sandeepprabhakula.subscriptionservice.entities.Subscription;
import com.sandeepprabhakula.subscriptionservice.service.SubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionController {
    private final SubscriptionServiceImpl subscriptionService;
    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription){
        return subscriptionService.createSubscription(subscription);
    }
    @GetMapping("/get-by-ott-name/{ottName}")
    public List<Subscription> getSubscriptionsByOttName(@PathVariable("ottName") String ottName){
        return subscriptionService.getSubscriptionsByOTTName(ottName);
    }
    @GetMapping("/get-by-uid/{uid}")
    public List<Subscription> getSubscriptionsByUid(@PathVariable("uid")String uid){
        return subscriptionService.getSubscriptionsByUID(uid);
    }
    @GetMapping("/subscription/{sid}")
    public Subscription getSubscriptionById(@PathVariable("sid")String sid){
        return subscriptionService.getSubscriptionByID(sid);
    }
    @PutMapping("/update")
    public Subscription updateSlotsOfSubscription(@RequestBody Subscription subscription){
        return subscriptionService.updateSlotsOfSubscription(subscription);
    }
}
