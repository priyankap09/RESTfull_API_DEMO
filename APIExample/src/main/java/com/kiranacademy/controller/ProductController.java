package com.kiranacademy.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiranacademy.entity.Product;
import com.kiranacademy.entity.ProductCharges;

@RestController
public class ProductController {

	@Autowired
	SessionFactory factory;


	@RequestMapping("getproducts/{prodid}")
	public Bill getProducts(@PathVariable int prodid){

		Bill bill = new Bill();

		Session session = factory.openSession();
		Product product = session.load(Product.class, prodid);


		String prodCategory = product.getProdCategory();
		double basePrice = product.getProdPrice();

		Criteria criteria2 = session.createCriteria(ProductCharges.class);
		criteria2.add(Restrictions.eq("prodCategory", prodCategory));

		List<ProductCharges> listCharges = criteria2.list();
		if(listCharges.size() > 0) {


			double prodDisc = listCharges.get(0).getDiscount();
			double prod_gst = listCharges.get(0).getGst();
			double prodDeliveryCharges = listCharges.get(0).getDeliveryCharges();

			double discount = basePrice * prodDisc/100;
			double gst = (basePrice - discount) * prod_gst/100;
			double finalPrice = (basePrice - discount) + gst + prodDeliveryCharges;

			Charges charges = new Charges();
			charges.setGst(gst);
			charges.setDeliveryCharges(prodDeliveryCharges);


			bill.setProductId(product.getProductId());
			bill.setName(product.getProdName());
			bill.setProdType(product.getProdType());
			bill.setProdCategory(prodCategory);
			bill.setBasePrice(basePrice);
			bill.setDiscount(discount);
			bill.setCharges(charges);
			bill.setFinalPrice(finalPrice);

		}

		return bill;		
	}
}
