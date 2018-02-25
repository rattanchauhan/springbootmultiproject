package com.core.controller;

import com.core.model.CoreInfo;
import com.core.model.LimitedMobileInfo;
import com.mobile.controller.MobileController;
import com.mobile.controller.SubscriptionController;
import com.mobile.model.Subscription;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @Slf4j
public class CoreController implements CoreApi {

    @Autowired
    MobileController mobileController;
    @Autowired
    SubscriptionController subscriptionController;

    public ResponseEntity<CoreInfo> getInfo() {
        CoreInfo info = new CoreInfo();
        info.title("Core API").message("Core API alpha version");
        return ResponseEntity.ok(info);
    }

    public ResponseEntity<LimitedMobileInfo> getMobileInfo() {
        LimitedMobileInfo info = new LimitedMobileInfo();
        ResponseEntity<com.mobile.model.MobileInfo> response = (ResponseEntity<com.mobile.model.MobileInfo>)mobileController.getInfo();
        log.info(response.toString());
        com.mobile.model.MobileInfo mobile = (com.mobile.model.MobileInfo)response.getBody();
        info.title(mobile.getTitle());
        ResponseEntity<List<Subscription>> result = (ResponseEntity<List<Subscription>>)subscriptionController.getSubscriptions();
        log.info(result.toString());
        return ResponseEntity.ok(info);
    }

}
