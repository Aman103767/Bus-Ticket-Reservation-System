package com.redbus.usecases;

import java.util.Scanner;

import com.redbus.dao.CustomerDao;
import com.redbus.dao.CustomerDaoImpl;
import com.redbus.exceptions.BusException;
import com.redbus.exceptions.CustomerException;

public class CancelTicketUseCase {
	
	public static void cancelTicket() {
		Scanner input = new Scanner(System.in);
		System.out.println("⤊⤊⤊⤊⤊⤊⤊ Enter The Ticket Details ⤊⤊⤊⤊⤊⤊⤊");
		System.out.println("Enter your Customer id..");
		 int cust_id = input.nextInt();
		 System.out.println("Enter your Bus No..");
		 int busno  = input.nextInt();
		CustomerDao cd = new CustomerDaoImpl();
		try {
			String result = cd.cancelTicket(cust_id, busno);
			System.out.println(result);
			
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
		 System.out.println(e.getMessage());
		}
		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
	}
	
  
  
}
