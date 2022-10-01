package com.redbus.usecases;

import java.util.List;
import java.util.Scanner;

import com.redbus.bean.CustomerAndBus;
import com.redbus.dao.CustomerDao;
import com.redbus.dao.CustomerDaoImpl;
import com.redbus.exceptions.CustomerException;

public class AllTicketDetailsUseCase {
       public static void details() {
    	   System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊ All The Ticket Details ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
   		
   		
   		CustomerDao cd = new CustomerDaoImpl();
   		try {
   			List<CustomerAndBus> list = cd.AllTicketDetails();
   			list.forEach(i-> System.out.println(i));
   		} catch (CustomerException e) {
   			// TODO Auto-generated catch block
   			System.out.println(e.getMessage());
   		}
   		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");   
       }
	
}
