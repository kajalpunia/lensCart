package com.trainingapps.lenscartapp.customerms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.trainingapps.lenscartapp.customerms.dto.ProductDetails;
import com.trainingapps.lenscartapp.customerms.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.lenscartapp.customerms.entity.Customer;
import com.trainingapps.lenscartapp.customerms.service.ICustomerService;


@RestController
@RequestMapping("/lenscart")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;

	@Value("${products.baseUrl}")
	private String baseProductsUrl;



	@PostMapping("customer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer)
			throws CustomerNameAlreadyExistException {
		customerService.addCustomer(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}



	@GetMapping("customer/customerName/{customerName}")
	public ResponseEntity<Customer> getCustomerByName(@PathVariable("customerName") String customerName)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerByName(customerName), HttpStatus.OK);
	}



	@PostMapping("customer/login")
	public ResponseEntity<Customer> customerLogin(@RequestBody Customer customer, HttpSession session)
			throws WrongPasswordException, WrongUsernameAndPassword {
		Customer customer1 = customerService.loginCustomer(customer);
		session.setAttribute("customer", customer1);
		return new ResponseEntity<>(customer1, HttpStatus.OK);
	}


	@GetMapping("customer/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		if (session.getAttribute("customer") != null) {
			session.invalidate();
			return new ResponseEntity<>("Logout Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("You are not logged in", HttpStatus.BAD_REQUEST);
		}
	}

	
	@PutMapping("customer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer), HttpStatus.OK);
	}

	

	@DeleteMapping("customer/{customerId}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		List<Customer> customerList = customerService.deleteCustomer(customerId);
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	@GetMapping("customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId)
			throws CustomerNotFoundException {
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}

	@GetMapping("/products/byId/{id}")
	public ProductDetails getProductById(@PathVariable Long id) throws ProductNotFoundException {
		return customerService.getById(id);
	}

}