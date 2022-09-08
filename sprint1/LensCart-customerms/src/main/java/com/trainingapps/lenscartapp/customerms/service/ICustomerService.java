package com.trainingapps.lenscartapp.customerms.service;

import java.util.List;

import com.trainingapps.lenscartapp.customerms.dto.ProductDetails;
import com.trainingapps.lenscartapp.customerms.exceptions.*;
import org.springframework.stereotype.Service;

import com.trainingapps.lenscartapp.customerms.entity.Customer;

@Service
public interface ICustomerService {

	public Customer addCustomer(Customer customer) throws CustomerNameAlreadyExistException;

	public Customer getCustomerByName(String customerName) throws CustomerNotFoundException;

	public Customer loginCustomer(Customer customer) throws WrongPasswordException, WrongUsernameAndPassword;

	public Customer updateCustomer(Customer customer);

	public Customer getCustomerById(int customerId) throws CustomerNotFoundException;

	public List<Customer> deleteCustomer(int customerId) throws CustomerNotFoundException;

	public ProductDetails getById(Long productId) throws ProductNotFoundException;

}