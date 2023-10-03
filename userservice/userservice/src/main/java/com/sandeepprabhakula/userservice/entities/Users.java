package com.sandeepprabhakula.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    @Id
    private String uid;
    private String name;
    private String email;
    private String mobile;

    @Transient
    private List<Subscription> createdSubscription = new ArrayList<>();

    @Transient
    private List<Purchase> purchasedSubscription = new ArrayList<>();
}
