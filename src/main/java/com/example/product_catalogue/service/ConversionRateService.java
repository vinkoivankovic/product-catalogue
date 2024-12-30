package com.example.product_catalogue.service;

import com.example.product_catalogue.dto.ConversionRateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConversionRateService {

    @Value("${conversion.api.url}")
    private String conversionApiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Cacheable(value = "conversionRate", key = "'USD'")
    public Double getConversionRate() {
        try {
            String url = conversionApiUrl + "?valuta=USD";
            ConversionRateResponse[] responseArray = restTemplate.getForObject(url, ConversionRateResponse[].class);
            if (responseArray == null || responseArray.length == 0) {
                throw new IllegalStateException("No conversion rate data available.");
            }
            ConversionRateResponse response = responseArray[0];
            String middleRate = response.getRate().replace(",", ".");
            return Double.parseDouble(middleRate);
        } catch (Exception ex) {
            throw new IllegalStateException("Error while fetching conversion rate: " + ex.getMessage());
        }
    }
}
