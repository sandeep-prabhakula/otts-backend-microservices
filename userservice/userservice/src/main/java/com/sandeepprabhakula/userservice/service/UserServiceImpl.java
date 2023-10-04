package com.sandeepprabhakula.userservice.service;

import com.sandeepprabhakula.userservice.entities.Purchase;
import com.sandeepprabhakula.userservice.entities.Subscription;
import com.sandeepprabhakula.userservice.entities.Users;
import com.sandeepprabhakula.userservice.exception.RecordNotFoundException;
import com.sandeepprabhakula.userservice.external.services.PurchaseService;
import com.sandeepprabhakula.userservice.external.services.SubscriptionService;
import com.sandeepprabhakula.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final SubscriptionService subscriptionService;
    private final PurchaseService purchaseService;

    @Override
    public Users save(Users user) {
        String uid = UUID.randomUUID().toString();
        user.setUid(uid);
        return userRepository.save(user);
    }

    @Override
    public Users getUserByUid(String uid) {
        Users currentUser = userRepository.findById(uid).orElseThrow(() -> new RecordNotFoundException("User Not Found"));
        List<Subscription>currentUserCreatedSubscriptions = subscriptionService.getSubscriptionsByUid(currentUser.getUid());
        currentUser.setCreatedSubscription(currentUserCreatedSubscriptions);
        List<Purchase> currentUserPurchases = purchaseService.getAllPurchasesByUid(currentUser.getUid());
        currentUser.setPurchasedSubscription(currentUserPurchases);
        return currentUser;
    }

//    @Override
//    public List<Users> getAllUsers() {
//        return userRepository.findAll();
//    }

    @Override
    public Users findUserByEmail(String email) {
        Users currentUser = userRepository.findByEmail(email).orElseThrow(() -> new RecordNotFoundException("User Not Found"));
        return currentUser;
    }
}
