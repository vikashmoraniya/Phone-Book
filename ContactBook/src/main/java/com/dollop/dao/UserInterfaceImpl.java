package com.dollop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dollop.model.UserLogin;
import com.dollop.util.DbConnection;

public class UserInterfaceImpl implements UserInterface {
	Connection con = null;

	@Override
	public boolean insertUser(UserLogin user) throws SQLException {
		con = DbConnection.dbConnection();
		String dml = "insert into userlogin (userName,userPassword) value(?,?)";
		PreparedStatement prst = con.prepareStatement(dml);
		prst.setString(1, user.getName());
		prst.setString(2, user.getPassword());
		if (prst.executeUpdate() != 0)
			return true;
		return false;
	}

	@Override
	public UserLogin viewUserById(int id) {
		try {
			con = DbConnection.dbConnection();
			String drl = "select * from userlogin where id=" + id;
			PreparedStatement prst = con.prepareStatement(drl);
			ResultSet rs = prst.executeQuery();
			if (rs.next()) {
				UserLogin user = new UserLogin();
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				user = new UserLogin(id1, name, password);
				return user;
			} else
				System.out.println("no data found ?||");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean loginUser(String name,String password) {
		
		boolean b=false;
		try {
			con = DbConnection.dbConnection();
			String dml = "select * from userlogin";
			PreparedStatement prst = con.prepareStatement(dml);
			ResultSet rs = prst.executeQuery();
			while (rs.next()) {
				
				if(name.equals(rs.getString(2))) {
					if(password.equals(rs.getString(3)))
						b=true;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("boolean data1 "+b);
		return b;
	}

	@Override
	public boolean updateUser(UserLogin user) {
		try {
			con = DbConnection.dbConnection();
			String ddl = "update userlogin set userName=?,userPassword=? where id="+user.getId();
			PreparedStatement prst = con.prepareStatement(ddl);
			prst.setString(1, user.getName());
			prst.setString(2, user.getPassword());
			prst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean deleteUser(int id) {
		try {
			con = DbConnection.dbConnection();
			String sql = "delete from userlogin where id=?";
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, id);
			prst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

}
