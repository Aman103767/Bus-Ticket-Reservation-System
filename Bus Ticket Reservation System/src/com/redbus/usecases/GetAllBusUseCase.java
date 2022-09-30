package com.redbus.usecases;

import java.util.List;
import java.util.Scanner;

import com.redbus.bean.Bus;
import com.redbus.dao.CustomerDao;
import com.redbus.dao.CustomerDaoImpl;
import com.redbus.exceptions.BusException;

public class GetAllBusUseCase {
	
	public static  void getAllBus() {
		 Scanner input = new Scanner(System.in);
		 System.out.println("⤊⤊⤊⤊⤊⤊ Enter the Source And Destination ⤊⤊⤊⤊⤊⤊⤊");
		System.out.println("FROM");
	    String source = input.nextLine();
	    System.out.println("TO");
	    String destination = input.nextLine();
		CustomerDao cd  = new CustomerDaoImpl();
		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
		
		List<Bus> list;
		try {
			list = cd.getAllBusByRoute(source, destination);
			list.forEach(i->{
				System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊ Bus Details ⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
				System.out.println("Bus NO : "+ i.getBusno());
				System.out.println("Bus Name : "+ i.getBusName());
				System.out.println("From : " + i.getSource());
				System.out.println("To : "+ i.getDestination());
				System.out.println("Bus Type : "+i.getBustype());
				System.out.println("Seats : " + i.getSeats());
				System.out.println("Arrival : "+ i.getArrival());
				System.out.println("Departure : "+ i.getDeparture());
				System.out.println("Availability : " + i.getAvailability());
				System.out.println("Bus Fare : ₹"+i.getBusfare());
				System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
			});
		} catch (BusException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
 
}
