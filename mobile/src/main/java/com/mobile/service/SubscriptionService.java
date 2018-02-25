package com.mobile.service;

import com.mobile.domain.SubscriptionRepository;
import com.mobile.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository
                .findAll()
                .stream()
                .map(subscription  -> {
                    Subscription sub = new Subscription();
                    sub
                            .id(String.valueOf(subscription.getId()))
                            .msisdn(subscription.getMsisdn())
                            .productName(subscription.getMsisdn());
                    return sub;
                })
                .collect(Collectors.toList());
    }
}
