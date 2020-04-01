/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.util.DBInteraction;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class UserDao implements IUser{

	@Override
	public int adduser(User u) {
		DBInteraction.connect();
		int nb=DBInteraction.Maj("insert into user values(null,'"+u.getNom()+"','"+u.getLog()+"','"+u.getPass()+"','"+u.getRole()+"')");
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public int adduser(String nom, String log, String pass) {
		DBInteraction.connect();
		int nb=DBInteraction.Maj("insert into user values(null,'"+nom+"','"+log+"','"+pass+"')");
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public User authentification(String log, String pass) {
		User u=null;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select * from user where log='"+log+"' and pass='"+pass+"'");
		try {
			if(rs.next())
			{
				u=new User(rs.getInt(1),rs.getString(4), rs.getString(2), rs.getString(3), rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
