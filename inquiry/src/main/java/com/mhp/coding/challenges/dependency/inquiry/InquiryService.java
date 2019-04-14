package com.mhp.coding.challenges.dependency.inquiry;

import com.mhp.coding.challenges.dependency.notifications.EmailHandler;
import com.mhp.coding.challenges.dependency.notifications.PushNotificationHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InquiryService {

    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

    @Autowired
    EmailHandler emailHandler;
    @Autowired
    PushNotificationHandler pushNotificationHandler;

    public void create(final Inquiry inquiry) {
        emailHandler.sendEmail(inquiry);
        pushNotificationHandler.sendNotification(inquiry);
        LOG.info("User sent inquiry: {}", inquiry);
    }

}
