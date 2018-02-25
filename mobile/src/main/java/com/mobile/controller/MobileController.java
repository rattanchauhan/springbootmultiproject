package com.mobile.controller;

import com.mobile.model.MobileInfo;
import com.mobile.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MobileController implements MobileApi {

    @Autowired
    SubscriptionService subscriptionService;

    public ResponseEntity<MobileInfo> getInfo() {
        MobileInfo info = new MobileInfo();
        info.title("Mobile API").message("Mobile API alpha version");
        log.info(subscriptionService.getAllSubscriptions().toString());
        return ResponseEntity.ok(info);
    }

}
