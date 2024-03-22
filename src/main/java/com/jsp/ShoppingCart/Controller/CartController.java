package com.jsp.ShoppingCart.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CartDAO;
import com.jsp.ShoppingCart.dao.CustomerDAO;
import com.jsp.ShoppingCart.dto.Cart;
import com.jsp.ShoppingCart.dto.Customer;
import com.jsp.ShoppingCart.dto.Item;

@Controller
public class CartController {
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	CustomerDAO cuDao;
	
	@RequestMapping("/fetchitemsfromcart")
	public ModelAndView fetchItemsFromCart(HttpSession session) {
		Customer c=(Customer) session.getAttribute("customerinfo");
		
		Customer customer=cuDao.findCartById(c.getId());
		Cart cart=customer.getCart();
		List<Item> items=cart.getItems();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("itemslist", items);
		mav.addObject("totalprice", cart.getTotalprice());
		mav.setViewName("displaycartitemstocustomer");
		
		return mav;
	}
}
