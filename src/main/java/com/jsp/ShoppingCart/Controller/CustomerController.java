package com.jsp.ShoppingCart.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.CustomerDAO;
import com.jsp.ShoppingCart.dto.Customer;

@Controller
public class CustomerController {

	@Autowired
	CustomerDAO dao;

	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer() {

		Customer customer = new Customer();
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerobj", customer);
		mv.setViewName("customerRegister");

		return mv;
	}

	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customerobj") Customer c) {

		dao.saveCustomer(c);

		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Registered Successfully");
		mav.setViewName("customerLoginForm");

		return mav;
	}

	@RequestMapping("/customerloginvalidation")
	public ModelAndView customerlogin(ServletRequest request, HttpSession sess) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Customer customer = dao.login(email, password);
		ModelAndView mv = new ModelAndView();

		if (customer != null) {
			mv.addObject("msg", "Successfully Login");
			mv.setViewName("customeroptions");
			sess.setAttribute("customerinfo", customer);
			return mv;
		} else {
			mv.addObject("msg", "Invalid Credentials");
			mv.setViewName("customerLoginForm");
			return mv;
		}

	}

}
