package com.sandeepprabhakula.subscriptionservice.repository;

import com.sandeepprabhakula.subscriptionservice.entities.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription,String> {
    List<Subscription> findAllByOwnerId(String uid);

    List<Subscription> findAllByOttName(String ottName);
}
