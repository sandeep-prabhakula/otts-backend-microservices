package com.sandeepprabhakula.purchasesservice.service;

import com.sandeepprabhakula.purchasesservice.entities.Purchase;
import com.sandeepprabhakula.purchasesservice.entities.Subscription;
import com.sandeepprabhakula.purchasesservice.exception.RecordNotFoundException;
import com.sandeepprabhakula.purchasesservice.external.services.SubscriptionService;
import com.sandeepprabhakula.purchasesservice.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final SubscriptionService subscriptionService;

    @Override
    public Purchase createPurchase(Purchase purchase) {
        Subscription subscription = subscriptionService.getSubscriptionById(purchase.getSubscriptionId());
        int currentSlots = subscription.getNumberOfSlots();
        if (!purchase.getConsumerUid().equals(subscription.getOwnerId()) && currentSlots != 0) {
            currentSlots--;
            subscription.setSubId(subscription.getSubId());
            subscription.setPrice(subscription.getPrice());
            subscription.setOwnerId(subscription.getOwnerId());
            subscription.setNumberOfSlots(currentSlots);
            subscription.setOttName(subscription.getOttName());
            subscription.setDurationInDays(subscription.getDurationInDays());
            subscriptionService.updateSlotsOfSubscription(subscription);
            return purchaseRepository.save(purchase);
        }
        return new Purchase();
    }

    @Override
    public List<Purchase> getAllPurchasesOfUser(String uid) {

        return purchaseRepository.findAllByConsumerUid(uid);
    }

    @Override
    public Purchase getPurchaseById(String purchaseId) {
        return purchaseRepository.findById(purchaseId).orElseThrow(() -> new RecordNotFoundException("Purchase not available with id " + purchaseId));
    }
}
