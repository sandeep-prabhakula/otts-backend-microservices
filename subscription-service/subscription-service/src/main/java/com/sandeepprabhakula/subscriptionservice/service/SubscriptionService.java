package com.sandeepprabhakula.subscriptionservice.service;

import com.sandeepprabhakula.subscriptionservice.entities.Subscription;

import java.util.List;

public interface SubscriptionService {

    // get subscriptions by uid
    List<Subscription> getSubscriptionsByUID(String uid);

    // get subscriptions by ottName
    List<Subscription> getSubscriptionsByOTTName(String ottName);

    // get subscription by sub_id;
    Subscription getSubscriptionByID(String s_id);

    // create subscription by uid
    Subscription createSubscription(Subscription subscription);

    Subscription updateSlotsOfSubscription(Subscription subscription);
}
