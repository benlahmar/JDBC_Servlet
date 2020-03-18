/**
 * 
 */
package com.util;

import com.dao.ProduitDao;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProduitDao pm=new ProduitDao();
		int nb=pm.addProduit("RAM",800,32,"RAM DDR 8Go....");
		System.out.println(nb +"linges ajoutées");
		
	}

}
