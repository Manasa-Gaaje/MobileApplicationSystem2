package com.appmobile.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appmobile.model.Customer;

public interface CustomerJpaRepository extends JpaRepository<Customer,Integer>
{

	

}
