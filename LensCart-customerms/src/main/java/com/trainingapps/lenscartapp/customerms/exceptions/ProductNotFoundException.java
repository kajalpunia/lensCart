package com.trainingapps.lenscartapp.customerms.exceptions;

import com.trainingapps.lenscartapp.customerms.dto.ProductDetails;

public class ProductNotFoundException  extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}
