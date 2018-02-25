package com.mobile.controller;

import com.mobile.model.Subscription;
import com.mobile.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubscriptionController implements SubscriptionsApi {
    @Autowired
    SubscriptionService subscriptionService;

    public  ResponseEntity<List<Subscription>> getSubscriptions() {
        log.info(subscriptionService.getAllSubscriptions().toString());
        return ResponseEntity.ok(subscriptionService.getAllSubscriptions());
    }
}
