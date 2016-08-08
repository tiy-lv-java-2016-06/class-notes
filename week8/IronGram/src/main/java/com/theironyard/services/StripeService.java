package com.theironyard.services;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 8/5/16.
 */
@Service
public class StripeService {

    @Value("${stripe.key.secret}")
    private String secretKey;

    @PostConstruct
    public void setup(){
        Stripe.apiKey = secretKey;
    }

    public Charge chargeCard(int amount, String token){
        Map<String, Object> params = new HashMap<>();
        params.put("amount", amount);
        params.put("currency", "usd");
        params.put("source", token);
        params.put("description", "Charging you for nothing");
        Charge charge = null;
        try {
            charge = Charge.create(params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return charge;
    }

    public Charge chargeCard(double amount, String token){
        return chargeCard((int)(amount * 100), token);
    }

}
