/**
 * 
 */
package com.model;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Produit {

	int id;
	String designation;
	double prix;
	int quantite;
	String descrition;
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
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	/**
	 * @return the descrition
	 */
	public String getDescrition() {
		return descrition;
	}
	/**
	 * @param descrition the descrition to set
	 */
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(int id, String designation, double prix, int quantite, String descrition) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.descrition = descrition;
	}
	public Produit(String designation, double prix, int quantite, String descrition) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantite = quantite;
		this.descrition = descrition;
	}
	
}
