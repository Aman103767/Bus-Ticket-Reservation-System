package com.redbus.presentation;

import java.util.Scanner;

import com.redbus.usecases.AllTicketDetailsUseCase;
import com.redbus.usecases.AllocateSeatToCustomer;
import com.redbus.usecases.CancelTicketUseCase;
import com.redbus.usecases.GetAllBusUseCase;
import com.redbus.usecases.LoginUseCase;
import com.redbus.usecases.RegisterBusUseCase;
import com.redbus.usecases.RegisterCustomerUseCase;

public class Persentation{
	static boolean ordering = true;
	static boolean case1 = true;
	static boolean case2 = true;
	
	
	static void firstCase() {
		Scanner input = new Scanner(System.in);
		do {
		 System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊ Customer ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		 System.out.println("1. Search Buses \n2. Book Ticket \n3. Cancel Ticket \n4. Exit");
		 System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		 
		 int choice = input.nextInt();
		 
		 switch(choice){
		 
		 
		 case 1:
			 GetAllBusUseCase.getAllBus();;
			 break;
		 
		 case 2:
			boolean flag =  RegisterCustomerUseCase.addCustomer();
			if(flag)
			 AllocateSeatToCustomer.allocateSeat();
			 break;
		 
		 case 3:
			 CancelTicketUseCase.cancelTicket();
			 break;
		 case 4:
			 case1 = false;
			 break;
		 default: 
			 System.out.println("Enter the right choice");
		 }
		
			 
		
		 }while(case1);
			 
		 
		 
	}
	static void secondCase() {
		Scanner input = new Scanner(System.in);
		do {
		 System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊ Administrator ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		 System.out.println("1. Register Bus\n2. View All Customer Ticket \n3. Exit");
		 System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		 int choice = input.nextInt();
		 switch(choice) {
		 case 1:
			 RegisterBusUseCase.addbus();
			 break;
		 case 2:
			 AllTicketDetailsUseCase.details();
			 break;
		 case 3:
		 case2 = false;
		 break;
		 default:
			 System.out.println("Enter the right choice");
		 }
		 
		
		}while(case2);
		 
	}
 	static void menu() {
		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊ Bus Ticket Reservation System  ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		System.out.println("1. Customer \n2. Adminstrator \n3. Exit");
		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		do {
			menu();
			System.out.println("Enter Choice : ");
			
			
		int choice = input.nextInt();
		switch(choice){
		case 1:
			Persentation.firstCase();
			break;
		case 2: 
		    LoginUseCase l = new LoginUseCase();
			if(l.login())
			Persentation.secondCase();
			break;
			
		case 3:
			System.out.println("Thank You! for using this application");
			ordering = false;
			break;
	    default : 
	    	System.out.println("Please Enter the valid choice");
		}
		
	   
	}
		while(ordering);
	}

}
