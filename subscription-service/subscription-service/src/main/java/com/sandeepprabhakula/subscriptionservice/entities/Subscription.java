package com.sandeepprabhakula.subscriptionservice.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("subscriptions")
public class Subscription {
    @Id
    private String subId;
    private String ownerId;
    private OTTName ottName;
    private int numberOfSlots;
    private double price;
    private int durationInDays;
}
