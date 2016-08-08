package com.theironyard;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.instance.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by jeff on 8/5/16.
 */
@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public TwilioRestClient twilioRestClient(
            @Value("${twilio.sid}") String sid,
            @Value("${twilio.token}") String token){
        return new TwilioRestClient(sid, token);

    }

    @Bean
    public Account twilioAccount(TwilioRestClient twilioRestClient){
        return twilioRestClient.getAccount();
    }

    //@Scheduled(fixedRate = 5000)
    public void helloWorld(){
        System.out.println("Hello World");
    }


}
