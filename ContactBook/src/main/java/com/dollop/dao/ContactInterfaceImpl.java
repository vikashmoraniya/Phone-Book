package com.dollop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dollop.model.Contact;
import com.dollop.util.DbConnection;

public class ContactInterfaceImpl implements ContactInterface {
	Connection con = null;

	public boolean createContact(Contact contact) {
		try {
			con = DbConnection.dbConnection();
			String dml = "insert into mycontact1 (name , email , phone) values(?,?,?)";
			PreparedStatement prst = con.prepareStatement(dml);
			prst.setString(1, contact.getName());
			prst.setString(2, contact.getEmail());
			prst.setString(3, contact.getPhone());
			if(prst.executeUpdate()!=0)
				return true;
			return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Contact> viewAllContact() {
		try {
			con = DbConnection.dbConnection();
			ArrayList<Contact> ac = new ArrayList<Contact>();
			String sql = "select * from mycontact1";
			PreparedStatement prst = con.prepareStatement(sql);
			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				Contact cont = new Contact();
				cont.setId(rs.getInt(1));
				cont.setName(rs.getString(2));
				cont.setEmail(rs.getString(3));
				cont.setPhone(rs.getString(4));
				ac.add(cont);
			}return ac;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public Contact viewContactById(int id) {
		try {
			con = DbConnection.dbConnection();

			String sql = "select * from mycontact1 where id="+id;
			PreparedStatement prst = con.prepareStatement(sql);
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				Contact cont = new Contact();
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				cont = new Contact(id1, name, email, phone);
				return cont;
			} else
				System.out.println("no data found ?||");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateContact(Contact contact) {
		try {
			con = DbConnection.dbConnection();
			String sql = "update mycontact1 set name=?,email=?,phone=? where id="+contact.getId();
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, contact.getName());
			prst.setString(2, contact.getEmail());
			prst.setString(3, contact.getPhone());
			prst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteContact(int id) {
		try {
			con = DbConnection.dbConnection();
			String sql = "delete from mycontact1 where id=?";
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, id);
			prst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
