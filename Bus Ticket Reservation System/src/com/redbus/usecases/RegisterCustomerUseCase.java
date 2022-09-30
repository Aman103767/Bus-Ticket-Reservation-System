package com.redbus.usecases;

import java.util.Scanner;

import com.redbus.bean.Customer;
import com.redbus.dao.CustomerDao;
import com.redbus.dao.CustomerDaoImpl;
import com.redbus.exceptions.CustomerException;

public class RegisterCustomerUseCase {
	
	public static void addCustomer() {
		Scanner input = new Scanner(System.in);
		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊ Enter Customer Details ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		System.out.println("Enter customer id ");
		int cust_id = Integer.parseInt(input.nextLine());
		System.out.println("Enter customer name");
		String cname = input.nextLine();
		System.out.println("Enter your Gender");
		String gender = input.nextLine();
		System.out.println("Enter your age");
		int age = Integer.parseInt(input.nextLine());
		System.out.println("Enter the contact address");
	    String contact_address = input.nextLine();
	    
	    CustomerDao cd = new CustomerDaoImpl();
	    Customer c = new Customer();
	    c.setCust_id(cust_id);
	    c.setCname(cname);
	    c.setGender(gender);
	    c.setAge(age);
	    c.setContact_address(contact_address);
	    String result;
		try {
			result = cd.RegisterCustomer(c);
			   System.out.println(result);
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		
	}
	
	
  
}
