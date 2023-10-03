package com.sandeepprabhakula.purchasesservice.entities;

import lombok.Data;

@Data
public class Subscription {
    private String subId;
    private String ownerId;
    private OTTName ottName;
    private int numberOfSlots;
    private double price;
    private int durationInDays;
}
