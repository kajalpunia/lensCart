package com.lenscart.productms.service;

import com.lenscart.productms.entity.Products;
import com.lenscart.productms.exceptions.InvalidProductDataException;
import com.lenscart.productms.exceptions.InvalidProductTypeException;
import com.lenscart.productms.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public Products addProduct(Products product) throws InvalidProductTypeException;

    public void removeProduct(Long id) throws ProductNotFoundException;

    public Products updateProduct(Products product) throws InvalidProductDataException;

    public Products getProductById(Long id) throws ProductNotFoundException;

    public List<Products> getProductByName(String name) throws ProductNotFoundException;
    
    public List<Products> getAllProducts();
}
