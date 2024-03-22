package com.jsp.ShoppingCart.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CartDAO;
import com.jsp.ShoppingCart.dao.CustomerDAO;
import com.jsp.ShoppingCart.dao.OrdersDAO;
import com.jsp.ShoppingCart.dao.ProductDAO;
import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Item;
import com.jsp.ShoppingCart.dto.Orders;
import com.jsp.ShoppingCart.dto.Product;

@Controller
public class OrdersController {
	
	@Autowired
	OrdersDAO dao;
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping("/addorder")
	public ModelAndView addOrder()
	{
		Orders o=new Orders();
		ModelAndView mav=new ModelAndView();
		mav.addObject("ordersobj", o);
		mav.setViewName("ordersform");
		
		return mav;
	}
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(@ModelAttribute("ordersobj") Orders o,HttpSession session)
	{
		Customer c=(Customer)session.getAttribute("customerinfo");
		Customer customer=customerDAO.findCartById(c.getId());	
		Cart cart=customer.getCart();
		
		List<Item> items=cart.getItems();
		
		
		List<Item> itemslist=new ArrayList<Item>();
		
		List<Item> itemsWithGraterQuantity=new ArrayList<Item>();
		
		
		for(Item i:items) {
			Product p=productDAO.findProductById(i.getP_id());
			if(i.getQuatity()<p.getStock()) {
				itemslist.add(i);
				p.setStock(p.getStock()-i.getQuatity());
				 
				productDAO.updateProduct(p);
			}
			else
			{
				itemsWithGraterQuantity.add(i);
			}
		}
		o.setItems(itemslist);
		
		double totlapriceoforder=0;
		for(Item i:itemslist)
		{
			totlapriceoforder=totlapriceoforder+i.getPrice();
		}
		o.setTotalprice(totlapriceoforder);
		
		cart.setItems(itemsWithGraterQuantity);
		
		double totalprice=0;
		
		for(Item i:itemsWithGraterQuantity)
		{
			totalprice=totalprice+i.getPrice();
		}
		cart.setTotalprice(totalprice);
		
		
		List<Orders> orders= customer.getOrders();		
		if(orders.size()>0) {
			orders.add(o);
			customer.setOrders(orders);
		}else
		{
			List<Orders> orders1=new ArrayList<Orders>();
			orders1.add(o);
			customer.setOrders(orders1);
		}
		
		
		customer.setCart(cart);
		
		cartDAO.updateCart(cart);
		dao.saveOrders(o);
		customerDAO.updateCustomer(customer);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "Order Placed Successfully");
		mav.addObject("orderdetails", o);
		mav.setViewName("CustomerBill");
		
		return mav;
		
	}
}
