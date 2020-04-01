/**
 * 
 */
package com.model;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class User {
int id;
String nom,log,pass,role;

/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the nom
 */
public String getNom() {
	return nom;
}
/**
 * @param nom the nom to set
 */
public void setNom(String nom) {
	this.nom = nom;
}
/**
 * @return the log
 */
public String getLog() {
	return log;
}
/**
 * @param log the log to set
 */
public void setLog(String log) {
	this.log = log;
}
/**
 * @return the pass
 */
public String getPass() {
	return pass;
}
/**
 * @param pass the pass to set
 */
public void setPass(String pass) {
	this.pass = pass;
}


public User(String nom, String log, String pass, String role) {
	super();
	this.nom = nom;
	this.log = log;
	this.pass = pass;
	this.role = role;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(String nom, String log, String pass) {
	super();
	this.nom = nom;
	this.log = log;
	this.pass = pass;
}
/**
 * @return the role
 */
public String getRole() {
	return role;
}
/**
 * @param role the role to set
 */
public void setRole(String role) {
	this.role = role;
}
public User(int id, String nom, String log, String pass, String role) {
	super();
	this.id = id;
	this.nom = nom;
	this.log = log;
	this.pass = pass;
	this.role = role;
}


}
