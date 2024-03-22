package com.jsp.ShoppingCart.dao;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart.dto.Merchant;
import com.jsp.ShoppingCart.dto.Product;

@Repository
public class MerchantDAO {

	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	ProductDAO pdao;

	public void saveMerchant(Merchant merchant) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(merchant);
		et.commit();
	}

	public Merchant login(String email, String password) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			Merchant merchant = (Merchant) query.getSingleResult();
			return merchant;
		} catch (Exception e) {
			return null;
		}
	}

	public void updateMerchant(Merchant merchant) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(merchant);
		et.commit();
	}

	public void deleteCartById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Merchant merchant = em.find(Merchant.class, id);

		et.begin();
		em.remove(merchant);
		et.commit();
	}

	public Merchant findCartById(int id) {
		EntityManager em = emf.createEntityManager();

		Merchant merchant = em.find(Merchant.class, id);
		if (merchant != null) {
			return merchant;
		} else {
			return null;
		}
	}

	public Merchant deleteProductFromMerchant(int merchant_id,int product_id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Merchant merchant = em.find(Merchant.class, merchant_id);
		List<Product> products =  merchant.getProducts();
//		products.stream().filter(product->product.getId()!=product_id).collect(Collectors.toList());
		
		List<Product> productslist=new ArrayList();
		for(Product p:products) {
			if(p.getId()!=product_id) {
				productslist.add(p);
			}
		}
		
//		Product p=pdao.findProductById(product_id);
//		products.remove(p);
		merchant.setProducts(productslist);
		
		return merchant; 
		
		
	}
}
