package com.sandeepprabhakula.userservice.entities;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    private String subId;
    private String ownerId;
    private OTTName ottName;
    private int numberOfSlots;
    private double price;
    private int durationInDays;
}
