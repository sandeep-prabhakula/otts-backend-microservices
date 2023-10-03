package com.sandeepprabhakula.subscriptionservice.service;

import com.sandeepprabhakula.subscriptionservice.entities.Subscription;
import com.sandeepprabhakula.subscriptionservice.exceptions.RecordNotFoundException;
import com.sandeepprabhakula.subscriptionservice.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> getSubscriptionsByUID(String uid) {
        return subscriptionRepository.findAllByOwnerId(uid);
    }

    @Override
    public List<Subscription> getSubscriptionsByOTTName(String ottName) {
        return subscriptionRepository.findAllByOttName(ottName);
    }

    @Override
    public Subscription getSubscriptionByID(String s_id) {
        return subscriptionRepository.findById(s_id).orElseThrow(() -> new RecordNotFoundException("Subscription Not Found"));
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSlotsOfSubscription(Subscription subscription) {

        return subscriptionRepository.save(subscription);
    }
}
