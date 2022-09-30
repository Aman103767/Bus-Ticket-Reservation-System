package com.redbus.usecases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.redbus.bean.Bus;
import com.redbus.dao.CustomerDao;
import com.redbus.dao.CustomerDaoImpl;
import com.redbus.exceptions.BusException;

public class RegisterBusUseCase {
	
	public static void addbus() {
		Scanner input = new Scanner(System.in);
		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊ Enter the Bus Details ⤊⤊⤊⤊⤊⤊⤊⤊");
		System.out.println("Enter the bus number");
		int busno = Integer.parseInt(input.nextLine());
		System.out.println("Enter the bus name");
		String busName = input.nextLine();
		System.out.println("Enter the source");
		String source = input.nextLine();
		System.out.println("Enter the destination");
		String Destination = input.nextLine();
		System.out.println("Enter the BusType");
		String BusType  =  input.nextLine();
		System.out.println("Enter the Seats");

		int seats = Integer.parseInt(input.nextLine());
		//System.out.println("Enter the Arrival time");
		DateTimeFormatter formatOb = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime curr = LocalDateTime.now().plusDays(1).plusMinutes(10);
		
		String udf1= curr.format(formatOb);
		String arrival = udf1;

		//System.out.println("Enter the Departure time");
		DateTimeFormatter formatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime current = LocalDateTime.now().plusDays(1).plusMinutes(30);
		
		String udf= current.format(formatObj);
		
		String departure = udf;
		System.out.println("Enter the Availability of seats");
		int avail = Integer.parseInt(input.nextLine());
		System.out.println("Enter the bus fare");
		int busfare = Integer.parseInt(input.nextLine());
		
		Bus bus = new Bus();
		bus.setBusno(busno);
		bus.setBusName(busName);
		bus.setSource(source);
		bus.setDestination(Destination);
		bus.setBustype(BusType);
		bus.setSeats(seats);
		bus.setArrival(arrival);
		bus.setDeparture(departure);
		bus.setAvailability(avail);
		bus.setBusfare(busfare);
		 
		
		
		CustomerDao cd = new CustomerDaoImpl();
		String Result;
		try {
			Result = cd.RegisterBus(bus);
			System.out.println(Result);
		} catch (BusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊⤊");
	}
	
}
	

