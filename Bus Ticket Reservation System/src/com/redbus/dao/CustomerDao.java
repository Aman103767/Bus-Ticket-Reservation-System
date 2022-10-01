package com.redbus.dao;

import java.util.List;

import com.redbus.bean.Admin;
import com.redbus.bean.Bus;
import com.redbus.bean.Customer;
import com.redbus.bean.CustomerAndBus;
import com.redbus.exceptions.AdminException;
import com.redbus.exceptions.AllocateSeatToCustomerException;
import com.redbus.exceptions.BusException;
import com.redbus.exceptions.CustomerException;

public interface CustomerDao {

  public Admin login(String username, String password) throws AdminException;
	
  public String RegisterBus(Bus b ) throws BusException;
  
  public String RegisterCustomer(Customer c ) throws CustomerException;
  
  public String AllocateSeatToCustomer(int cust_id, int busno) throws AllocateSeatToCustomerException;
  
  public List<Bus> getAllBusByRoute(String source, String destination) throws BusException;
  
  public String cancelTicket(int cust_id, int busno)throws CustomerException;

  public CustomerAndBus contactPerson(int cust_id, int busno)throws CustomerException;
  
  public String minusSeats(int busno) throws BusException;
  
  public String plusSeats(int busno) throws BusException;
  
  public List<CustomerAndBus> AllTicketDetails() throws CustomerException;

  
}
