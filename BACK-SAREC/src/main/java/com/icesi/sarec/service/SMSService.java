package com.icesi.sarec.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSService {


    private AmazonSNS snsClient;

    @Autowired
    public SMSService(AmazonSNS snsClient) {
        this.snsClient = snsClient;
    }


    public void sendSMSMessage(String message, String mobile) {
        mobile = "+57" + mobile;
        PublishResult result = snsClient.publish(new PublishRequest().withMessage(message).withPhoneNumber(mobile));
        System.out.println("Message sent. Status was " + result.getSdkHttpMetadata().getHttpStatusCode());

    }


}