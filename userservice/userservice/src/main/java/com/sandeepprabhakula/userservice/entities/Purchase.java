package com.sandeepprabhakula.userservice.entities;

import lombok.Data;

@Data
public class Purchase {
    private String purchaseId;
    private String subscriptionId;
    private String consumerUid;
}
