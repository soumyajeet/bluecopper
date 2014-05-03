package com.bluecopper.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.bluecoppertech.dao.UserRegDAO;

@ManagedBean(name = "userRegHandler")
public class UserRegHandler {

	@Inject
	UserRegDAO userRegDAO;

	String fname;
	String lname;
	String email;
	
	

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void register() throws Exception {
		System.out.println(email);
		System.out.println(fname);
		System.out.println(lname);

		userRegDAO.register1(fname, lname, email);
		

	}
	
		
}
