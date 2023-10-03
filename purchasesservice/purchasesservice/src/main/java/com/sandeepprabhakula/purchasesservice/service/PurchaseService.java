package com.sandeepprabhakula.purchasesservice.service;

import com.sandeepprabhakula.purchasesservice.entities.Purchase;

import java.util.List;

public interface PurchaseService {

    // create purchase
    Purchase createPurchase(Purchase purchase);

    // getAll purchases of a user
    List<Purchase> getAllPurchasesOfUser(String uid);

    // get purchase data by id
    Purchase getPurchaseById(String purchaseId);
}
