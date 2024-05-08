package com.example.sendMail.Controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripePaymentController {

    @Value("${stripe.apikey}")
    String stripeKey;

    @RequestMapping("/vvv")
    public String index() {
        return "hello" + stripeKey;
    }

}
