package com.appmobile.repository;

import java.util.ArrayList;
import com.appmobile.model.Customer;

public interface CustomerRepository 
{
	ArrayList<Customer> getCustomers();
	Customer getCustomerById(int customerId);
	Customer addCustomer(Customer customer);
	Customer updateCustomer(int customerId,Customer customer);
	void deleteCustomer(int customerId);

}
