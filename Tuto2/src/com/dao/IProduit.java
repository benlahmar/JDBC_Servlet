/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Produit;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public interface IProduit {

	public int addProduit(Produit p);
	public int addProduit(String designation, double prix, int quantite, String descrition);
	public Produit findProduitById(int id);
	public int deleteproduit(int id);
	public List<Produit> allproduit();
	public int updateproduit(int id, Produit p);
}
