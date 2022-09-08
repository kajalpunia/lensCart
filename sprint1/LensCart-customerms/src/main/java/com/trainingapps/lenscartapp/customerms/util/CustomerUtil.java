package com.trainingapps.lenscartapp.customerms.util;

import com.trainingapps.lenscartapp.customerms.dto.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CustomerUtil {
    @Value("${products.baseUrl}")
    private String baseProductsUrl;

    @Autowired
    private RestTemplate restTemplate;

    public ProductDetails fetchProductsById(Long productId){
        String url = baseProductsUrl+"/byId/"+productId;
        ProductDetails details = restTemplate.getForObject(url,ProductDetails.class);
        return details;
    }

}
