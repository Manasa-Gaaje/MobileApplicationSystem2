package com.appmobile.repository;

import java.util.ArrayList;
import com.appmobile.model.Customer;
import com.appmobile.model.Mobile;

public interface MobileRepository 
{
	ArrayList<Mobile> getMobiles();
	Mobile getMobileById(int mobileId);
	Mobile addMobile(Mobile mobile);
	Mobile updateMobile(int mobileId,Mobile mobile);
	void deleteMobile(int mobileId);
	Customer getMobileCustomer(int mobileId);
	

}
