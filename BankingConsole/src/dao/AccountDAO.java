package dao;

import model.*;
import util.*;

import java.sql.*;

public class AccountDAO {
	public Account createAccount(String holdername,String email,String phone,double ideposit) {
		try(Connection connection=DBConnection.getConnection()){
			PreparedStatement ps=connection.prepareStatement("INSERT INTO accounts(holder_name,email,phone,balance) VALUES ( ?, ?, ?, ?)");
			ps.setString(1, holdername);	
			ps.setString(2, email);		
			ps.setString(3, phone);		
			ps.setDouble(4, ideposit);
			int rowsAffected=ps.executeUpdate();
			if(rowsAffected>0) {
				ResultSet rs=ps.getGeneratedKeys();
				if(rs.next()) {
					int id=rs.getInt(1);
					rs.close();
					ps.close();
					connection.close();
					return new Account(id,holdername,ideposit);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Account getAccount(int accno) {
		try(Connection con=DBConnection.getConnection()){
			PreparedStatement ps=con.prepareStatement("SELECT * FROM accounts WHERE id= ?");
			ps.setInt(1,accno);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				return new Account(rs.getInt("id"), rs.getString("email"),rs.getDouble("balance"));
			}
			rs.close();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;		
	}
	public void updateBalance(int accno,double newbalance) {
		try(Connection con=DBConnection.getConnection()){
			PreparedStatement ps=con.prepareStatement("UPDATE accounts SET balance = ? WHERE id= ? ");
			ps.setDouble(1, newbalance);
			ps.setInt(2, accno);
			ps.executeUpdate();
			ps.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
