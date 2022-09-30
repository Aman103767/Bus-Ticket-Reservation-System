package com.redbus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.redbus.bean.Admin;
import com.redbus.bean.Bus;
import com.redbus.bean.Customer;
import com.redbus.bean.CustomerAndBus;
import com.redbus.exceptions.AdminException;
import com.redbus.exceptions.AllocateSeatToCustomerException;
import com.redbus.exceptions.BusException;
import com.redbus.exceptions.CustomerException;
import com.redbus.utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public Admin login(String username, String password)throws AdminException {
	
		// TODO Auto-generated method stub
		Admin admin =  null;
		try(Connection conn = DBUtil.provideConnection()){
			
	PreparedStatement ps = conn.prepareStatement("Select * from admin where username = ? And password = ?");
	  
	
	    ps.setString(1, username);
	    ps.setString(2, password);
	    
	    ResultSet rs = ps.executeQuery();
	    
	    if(rs.next()) {
	    	
	     admin = new Admin(rs.getString("username"),rs.getString("password"));
	    }else {
	     throw  new AdminException("Please Enter Correct username and password");
	
			
	    }
	    
			
		}catch(SQLException e) {
			
		}
		
	return  admin;
	}

	@Override
	public String RegisterBus(Bus b) throws BusException{
		String message = "not inserted";
		// TODO Auto-generated method stub
		Bus bus = null;
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("insert into bus values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, b.getBusno());
			ps.setString(2, b.getBusName());
			ps.setString(3, b.getSource());
			ps.setString(4, b.getDestination());
			ps.setString(5, b.getBustype());
			ps.setInt(6, b.getSeats());
			ps.setString(7,b.getArrival());
			ps.setString(8,b.getDeparture());
			ps.setInt(9,b.getAvailability());
			ps.setInt(10, b.getBusfare());
			
			int x  = ps.executeUpdate();
			if(x>0) {
				message = "Bus is added to database";
			}
			
		}catch(SQLException e) {
			
			BusException be = new BusException(e.getMessage());
		          throw be;
		}
		
		
		
		return message;
	}

	@Override
	public String RegisterCustomer(Customer c)throws CustomerException{
		// TODO Auto-generated method stub
		String message = "Not inserted";
		
		try(Connection conn = DBUtil.provideConnection()){
			
		 PreparedStatement ps = conn.prepareStatement("insert into customer values(?,?,?,?,?)");
	     ps.setInt(1, c.getCust_id());
	     ps.setString(2,c.getCname());
	     ps.setString(3,c.getGender());
	     ps.setInt(4, c.getAge());
	     ps.setString(5, c.getContact_address());
	     
	     int x = ps.executeUpdate();
	     if(x>0) {
	    	 message = "customer is added";
	     }else {
	    	 throw new CustomerException("Enter the correct details");
	     }
	     
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String AllocateSeatToCustomer(int cust_id, int busno) throws AllocateSeatToCustomerException{
		// TODO Auto-generated method stub
		String message = "Please Enter Correct Details";
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("Select * from customer where cust_id = ?");
			ps.setInt(1, cust_id);
	        ResultSet rs = ps.executeQuery();
	        if(rs.next()) {
	        	PreparedStatement ps2 = conn.prepareStatement("Select * from bus where busno = ?");
	        	ps2.setInt(1, busno);
	        	ResultSet rs2 = ps2.executeQuery();
	        	if(rs2.next()) {
	        		PreparedStatement ps3 = conn.prepareStatement("insert into bus_customer values(?,?)");
	        		ps3.setInt(1, cust_id);
	        		ps3.setInt(2, busno);
	        		int x = ps3.executeUpdate();
	        		if(x>0) {
	        			message = "Your seat is confirmed";
	        		}
	        	
	        	}
	        }
			
			
			
		}catch(SQLException e) {
			throw new AllocateSeatToCustomerException("Please enter the correct details");
		}
		return message;
	}

	@Override
	public List<Bus> getAllBusByRoute(String source ,String destination)throws BusException {
		// TODO Auto-generated method stub
		List<Bus> list  = new ArrayList<>();
		
		try(Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps =conn.prepareStatement("Select * from bus where source = ? And destination = ?");
			ps.setString(1, source);
			ps.setString(2,destination);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bus b = new Bus(rs.getInt("busno"),rs.getString("bname"),
						rs.getString("Source"),rs.getString("Destination"),
						rs.getString("BusType"),rs.getInt("Seats"),
						rs.getString("Arrival"),rs.getString("Departure"),
						rs.getInt("availability"),rs.getInt("busfare"));
				      
				
				list.add(b);
			}
		}
		catch(SQLException e) {
			throw new BusException(e.getMessage());
		}
		if(list.size() == 0) {
			throw new BusException("There is not bus for this route");
		}
		
		return list;
	}

	@Override
	public String cancelTicket(int cust_id, int busno) throws CustomerException {
		String message = "Please Enter the correct customer id and bus Number";
		try(Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps = conn.prepareStatement("Delete From bus_customer where cust_id =? And busno = ?");
		ps.setInt(1, cust_id);
		ps.setInt(2, busno);
		int x = ps.executeUpdate();
		if(x>0) {
			message = "Your ticket is canceled refund will come within 7 days";
		}
		}
		catch(SQLException e) {
			throw new CustomerException(e.getMessage());
		}
		return message;
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerAndBus contactPerson(int cust_id, int busno)throws CustomerException {
		// TODO Auto-generated method stub
	     CustomerAndBus cum = null;
       try(Connection conn = DBUtil.provideConnection()){
    	   
    	   PreparedStatement ps = conn.prepareStatement("select c.cust_id,c.cname,c.gender, c.age,c.contact_address,b.busno, b.bname, b.source, b.destination,b.busfare from bus b inner join customer c inner join bus_customer bc on b.busno = bc.busno And c.cust_id = bc.cust_id where c.cust_id = ? And b.busno = ?");
    	   ps.setInt(1, cust_id);
    	   ps.setInt(2, busno);
    	   ResultSet rs = ps.executeQuery();
    	   if(rs.next()) {
    	     cum = new CustomerAndBus(rs.getInt("cust_id"),rs.getString("cname"),rs.getString("gender"),rs.getInt("age")
    	    		 ,rs.getString("contact_address"),rs.getInt("busno"),
    	    		 rs.getString("bname"),rs.getString("source"),rs.getString("destination"),rs.getInt("busfare"));
    	   }else {
    		   throw new CustomerException("Please enter the correct details");
    	   }
       }catch(SQLException e) {
    	   System.out.println(e.getMessage());
    	 
       }
	
		
		return cum;
	}

	@Override
	public String minusSeats(int busno) throws BusException {
		// TODO Auto-generated method stub
		String message= "Please Enter the correct details";
		try(Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps = conn.prepareStatement("update bus set availability = availability - 1 where busno = ? And availability >0");
		ps.setInt(1, busno);
		int x = ps.executeUpdate();
		if(x>0) {
			message = "Seat is booked no of seats Availability is decreased";
		}else {
			throw new BusException("There is not seats availability for this bus");
		}
			
			
		}catch(SQLException e ) {
			throw new BusException(e.getMessage());
		}
		return message;
	}

	@Override
	public String plusSeats(int busno) throws BusException {
		// TODO Auto-generated method stub
		String message= "Please Enter the correct details";
		try(Connection conn = DBUtil.provideConnection()){
		PreparedStatement ps = conn.prepareStatement("update bus set availability = availability + 1 where busno = ?");
		ps.setInt(1, busno);
		int x = ps.executeUpdate();
		if(x>0) {
			message = "Seat is added to seat Availability";
		}else {
			throw new BusException("Seat is not booked");
		}
			
			
		}catch(SQLException e ) {
			throw new BusException(e.getMessage());
		}
		return message;
	}

}
