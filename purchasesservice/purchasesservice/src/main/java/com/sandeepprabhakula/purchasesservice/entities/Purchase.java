package com.sandeepprabhakula.purchasesservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("purchases")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
    @Id
    private String purchaseId;
    private String subscriptionId;
    private String consumerUid;
}
