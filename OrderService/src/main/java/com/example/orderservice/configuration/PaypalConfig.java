package com.example.orderservice.configuration;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaypalConfig {

//    @Value("${paypal.client.id}")
    private String clientSecret = "EJRDoyPnJfCVFMRnsmpNA-jakD84FV6dsM5jZubf3aUKA3v-0CfhHCpeBnj5mbI71wuqNUgHY5SQDe4i";
//    @Value("${paypal.client.secret}")
    private String clientId = "AcxOe4WrJm2bvd5PrfvkGXayDLrSTq3NiI_j-gA47X-1GD1CfP3RpMRu389hrqE3btRV0VQBgEdWs1Py";
//    @Value("${paypal.mode}")
    private String mode = "sandbox";

    public Map paypalConfig() {
        Map configMap = new HashMap<>();
        configMap.put("mode", mode);
        return configMap;
    }

    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalConfig());
    }

    @Bean
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalConfig());
        return context;
    }
}
