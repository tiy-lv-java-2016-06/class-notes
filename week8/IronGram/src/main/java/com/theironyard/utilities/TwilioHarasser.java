package com.theironyard.utilities;

import com.twilio.sdk.TwilioRestClient;
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
 * Created by jeff on 8/5/16.
 */
@Service
public class TwilioHarasser {

    @Autowired
    Account twilioAccount;

    SmsFactory messageFactory;

    @PostConstruct
    public void setup(){
        messageFactory = twilioAccount.getSmsFactory();
    }

    @Scheduled(fixedRate = 30000)
    public void harass() throws TwilioRestException {
        List<String> numberList = new ArrayList<>();
        //numberList.add("7023470469");
        //numberList.add("7023364453");
        numberList.add("7024605304");

        for(String number : numberList) {
            List<NameValuePair> messageParams = new ArrayList<NameValuePair>();
            messageParams.add(new BasicNameValuePair("From", "7023187997"));
            messageParams.add(new BasicNameValuePair("Body", "Domingo Loves You"));
            messageParams.add(new BasicNameValuePair("To", number));
            System.out.println("Harrasing " + number);
            messageFactory.create(messageParams);
        }



    }
}
