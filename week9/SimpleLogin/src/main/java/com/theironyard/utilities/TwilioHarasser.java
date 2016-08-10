package com.theironyard.utilities;

import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeff on 8/10/16.
 */
@Service
public class TwilioHarasser {

    @Autowired
    Account twilioAccount;

    SmsFactory smsFactory;

    @PostConstruct
    public void setup(){
        smsFactory = twilioAccount.getSmsFactory();
    }

    @Scheduled(fixedDelay = 1000)
    public void harass() throws TwilioRestException {
        String phone = "7028851916";
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("From", "7023187997"));
        params.add(new BasicNameValuePair("To", phone));
        params.add(new BasicNameValuePair("Body", "I am harassing you!!!!!!!!!!!!!!"));
        System.out.println("Sent Message");

        smsFactory.create(params);
    }
}
