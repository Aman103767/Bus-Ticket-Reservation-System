package com.redbus.usecases;

import java.util.Scanner;

import com.redbus.bean.Admin;
import com.redbus.dao.CustomerDao;
import com.redbus.dao.CustomerDaoImpl;
import com.redbus.exceptions.AdminException;
import com.redbus.exceptions.CustomerException;

public class LoginUseCase {
boolean flag = false;
	public boolean login() {
		Scanner input = new Scanner(System.in);
		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊ Login ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		System.out.println("Enter the User Name");
		String username = input.nextLine();
		System.out.println("Enter the Password");
	     String password = input.nextLine();
	     
	    CustomerDao  cd = new CustomerDaoImpl();
	    Admin admin;
		
			try {
				admin = cd.login(username, password);
				
				  System.out.println("Welcome -> " + admin.getUsername());
				flag = true;
			} catch (AdminException e) {
				// TODO Auto-generated catch block
		   System.out.println(e.getMessage());
			}
			return flag;
			 
		
	 
	    
	}
	
		
}
