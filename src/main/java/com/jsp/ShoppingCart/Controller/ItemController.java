package com.jsp.ShoppingCart.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CartDAO;
import com.jsp.ShoppingCart.dao.CustomerDAO;
import com.jsp.ShoppingCart.dao.ItemDAO;
import com.jsp.ShoppingCart.dao.ProductDAO;
import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Item;
import com.jsp.ShoppingCart.dto.Product;

@Controller
public class ItemController {
	@Autowired
	ItemDAO dao;

	@Autowired
	ProductDAO pDAO;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam("id") int id) {
		Product product = pDAO.findProductById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productobj", product);
		mav.setViewName("itemform");

		return mav;

	}

	@RequestMapping("/additemtocart")
	public ModelAndView addItemToCart(ServletRequest request, HttpSession session) {
		int product_id = Integer.parseInt(request.getParameter("id"));
		String brand = request.getParameter("brand");
		double price = Double.parseDouble(request.getParameter("price"));
		String model = request.getParameter("model");
		String category = request.getParameter("category");
		int quatity = Integer.parseInt(request.getParameter("quantity"));

		Item item = new Item();
		item.setBrand(brand);
		item.setCatagory(category);
		item.setModel(model);
		item.setQuatity(quatity);
		item.setP_id(product_id);
		item.setPrice(quatity * price);

		Customer customer = (Customer) session.getAttribute("customerinfo");
		Cart c = customer.getCart();

		if (c == null) {

			Cart cart = new Cart();

			List<Item> items = new ArrayList<Item>();
			items.add(item);

			cart.setItems(items);
			cart.setName(customer.getName());

			cart.setTotalprice(item.getPrice());
			customer.setCart(cart);

			dao.saveItem(item);
			cartDAO.saveCart(cart);
			customerDAO.updateCustomer(customer);

		} else {

			List<Item> items = c.getItems();
			if (items.size() > 0) {
				items.add(item);
				c.setItems(items);
				double totalprice = 0;
				for (Item i : items) {
					totalprice = totalprice + i.getPrice();
				}
				c.setTotalprice(totalprice);
				
				dao.saveItem(item);
				cartDAO.updateCart(c);
				customerDAO.updateCustomer(customer);
				
			} else {
				List<Item> itemlist = new ArrayList<Item>();
				itemlist.add(item);
				c.setItems(itemlist);
				c.setTotalprice(item.getPrice());
				
				dao.saveItem(item);
				cartDAO.updateCart(c);
				
				customerDAO.updateCustomer(customer);
				
			}

		}
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect://displayproducts");
		
		return mav;

	}
}
