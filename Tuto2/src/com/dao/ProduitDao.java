/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Produit;
import com.util.DBInteraction;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class ProduitDao implements IProduit{

	@Override
	public int addProduit(Produit p) {
		
		DBInteraction.connect();
		int nb=DBInteraction.Maj("insert into produit values(null,'"+p.getDescrition()+"',"+p.getPrix()+","+p.getQuantite()+",'"+p.getDescrition()+"')");
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public int addProduit(String designation, double prix, int quantite, String descrition) {
		DBInteraction.connect();
		int nb=DBInteraction.Maj("insert into produit values(null,'"+designation+"',"+prix+","+quantite+",'"+descrition+"')");
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public Produit findProduitById(int id) {
		Produit p=null;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select * from produit where id="+id);
		try {
			if(rs.next())
			{
				p=new Produit(rs.getInt(1),rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public int deleteproduit(int id) {
		DBInteraction.connect();
		int nb=DBInteraction.Maj("delete from produit where id="+id);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public List<Produit> allproduit() {
		List<Produit>  produits=new ArrayList<Produit>();
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select * from produit ");
		try {
			while(rs.next())
			{
				Produit p=new Produit(rs.getInt(1),rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5));
				produits.add(p);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public int updateproduit(int id, Produit p) {
		DBInteraction.connect();
		int nb=DBInteraction.Maj("update produit set desg='"+p.getDesignation()+"', prix="+p.getPrix()+", qte="+p.getQuantite()+", description='"+p.getDescrition()+"' where id="+id);
		DBInteraction.disconnect();
		return nb;
	}

}
