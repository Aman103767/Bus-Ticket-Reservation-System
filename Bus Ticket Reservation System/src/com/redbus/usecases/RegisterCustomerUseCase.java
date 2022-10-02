package com.redbus.usecases;

import java.util.Scanner;

import com.redbus.bean.Customer;
import com.redbus.dao.CustomerDao;
import com.redbus.dao.CustomerDaoImpl;
import com.redbus.exceptions.CustomerException;

public class RegisterCustomerUseCase {
	static boolean flag = true;
	public static boolean addCustomer() {
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
	  
		try {
			boolean result = cd.RegisterCustomer(c);
			if(result == false){
				flag = false;
				System.out.println("Enter the Correct details");
			}else {
				System.out.println("Customer is registered");
			}
			   //System.out.println(result);
		} catch (CustomerException e) {
			System.out.println(e.getMessage());
		}
	 System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
	 return flag;
	}
	
	
  
}
