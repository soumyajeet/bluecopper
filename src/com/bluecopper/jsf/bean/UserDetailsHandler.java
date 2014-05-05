package com.bluecopper.jsf.bean;

import java.util.List;


import javax.annotation.PostConstruct;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.bluecoppertech.dao.DataAccessException;
import com.bluecoppertech.dao.UserRegDAO;



@ManagedBean
@SessionScoped
public class UserDetailsHandler {
	
	@Inject
	UserRegDAO userRegDAO;
	
	
	List<UserDetails> details;


	public List<UserDetails> getDetails() {
		//System.out.println("called");
		return details;
	}


	public void setDetails(List<UserDetails> details) {
		this.details = details;
	}
	
	@PostConstruct
	public void showdata()
	{
		//System.out.println("hi");
		try {
			details = userRegDAO.getUserList();
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String deletedata(String name)
	{
		//System.out.println("sdsd");
		
		userRegDAO.deleteRow(name);
				
		return "userdetails.xhtml?faces-redirect=true";
	}
	
	
	
}

