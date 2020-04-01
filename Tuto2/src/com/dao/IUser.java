/**
 * 
 */
package com.dao;

import com.model.User;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public interface IUser {

	public int adduser(User u);
	public int adduser(String nom, String log, String pass);
	public User authentification(String log,String pass);
	
	
}
