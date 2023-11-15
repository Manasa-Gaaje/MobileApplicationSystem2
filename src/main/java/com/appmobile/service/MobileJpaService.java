package com.appmobile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.appmobile.model.Customer;
import com.appmobile.model.Mobile;
import com.appmobile.repository.MobileJpaRepository;
import com.appmobile.repository.MobileRepository;

@Service
public class MobileJpaService implements MobileRepository 
{
	@Autowired
	private MobileJpaRepository mobileJpaRepository;

	@Override
	public ArrayList<Mobile> getMobiles() 
	{
		List<Mobile> mobileList=mobileJpaRepository.findAll();
		ArrayList<Mobile> mobiles=new ArrayList<>(mobileList);
		return mobiles;
	}

	@Override
	public Mobile getMobileById(int mobileId) 
	{
		try
		{
			Mobile mobile=mobileJpaRepository.findById(mobileId).get();
			return mobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public Mobile addMobile(Mobile mobile) 
	{
	  mobileJpaRepository.save(mobile);
      return mobile;

	}

	@Override
	public Mobile updateMobile(int mobileId, Mobile mobile) 
	{
		try
		{
			Mobile existingMobile=mobileJpaRepository.findById(mobileId).get();
			if(mobile.getName()!=null)
			{
				existingMobile.setName(mobile.getName());
			}
			if(mobile.getImage()!=null)
			{
				existingMobile.setImage(mobile.getImage());
			}
			mobileJpaRepository.save(mobile);
			return existingMobile;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public void deleteMobile(int mobileId) 
	{
		try
		{
			Mobile mobile=mobileJpaRepository.findById(mobileId).get();
			if(mobile!=null)
			{
				mobileJpaRepository.deleteById(mobileId);
			}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

	@Override
	public Customer getMobileCustomer(int mobileId) 
	{
		try
		{
			Mobile mobile=mobileJpaRepository.findById(mobileId).get();
			return mobile.getCustomer();
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	
	

}

	