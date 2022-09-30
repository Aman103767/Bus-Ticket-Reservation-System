package com.redbus.usecases;

import java.util.Scanner;

import com.redbus.bean.Customer;
import com.redbus.bean.CustomerAndBus;
import com.redbus.dao.CustomerDao;
import com.redbus.dao.CustomerDaoImpl;
import com.redbus.exceptions.AllocateSeatToCustomerException;
import com.redbus.exceptions.CustomerException;

public class AllocateSeatToCustomer {
	
	public static void allocateSeat() {
		Scanner input = new Scanner(System.in);
		System.out.println("⤊⤊⤊⤊⤊ Enter the Details For Booking The Ticket ⤊⤊⤊⤊⤊");
		System.out.println("Enter the Customer id");
		int cust_id = input.nextInt();
		System.out.println("Enter the Bus Number");
		int Busno = input.nextInt();
		
	    CustomerDao cd = new CustomerDaoImpl();
	    try {
			String result  =cd.AllocateSeatToCustomer(cust_id, Busno);
			System.out.println(result);
			
			System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		if(result != "Please Enter Correct Details" ) {
			
		
			try {
				CustomerAndBus c = cd.contactPerson(cust_id,Busno);
				System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊ Contact Persons Details ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
			    System.out.println("Customer Id : "+ c.getCust_id());
			    System.out.println("Bus Number : "+ c.getBusno());
				System.out.println("Name : "+c.getCname());
				System.out.println("Bus Name : "+ c.getBname());
				System.out.println("Gender : "+ c.getGender());
				System.out.println("Age : "+ c.getAge());
				System.out.println("Contact Address : "+ c.getContact_address());
				System.out.println("From : "+ c.getSource());
				System.out.println("To : "+ c.getDestination());
				System.out.println("Bus Fare : ₹"+ c.getBusfare());
				System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
			} catch (CustomerException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		} catch (AllocateSeatToCustomerException e) {
			// TODO Auto-generated catch block
		  System.out.println(e.getMessage());
		}
	}
 
}
