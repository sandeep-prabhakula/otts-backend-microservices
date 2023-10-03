package com.sandeepprabhakula.purchasesservice.repository;

import com.sandeepprabhakula.purchasesservice.entities.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends MongoRepository<Purchase,String> {
    List<Purchase> findAllByConsumerUid(String uid);
}
