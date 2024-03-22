package com.jsp.ShoppingCart.Controller;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.MerchantDAO;
import com.jsp.ShoppingCart.dto.Merchant;

@Controller
public class MerchantController {
	
	@Autowired
	MerchantDAO dao;
	
	@RequestMapping("/addmerchant")
	public ModelAndView addMerchant() {
		
		Merchant m=new Merchant();
		ModelAndView mv=new ModelAndView();
		mv.addObject("merchantobj", m);
		mv.setViewName("merchantform");
		return mv;
	}
	@RequestMapping("/savemechant")
	public ModelAndView saveMerchant(@ModelAttribute("merchantobj") Merchant m) {
		dao.saveMerchant(m);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg","Data Saved Successfully");
		mv.setViewName("menu");
		
		return mv;
	}
	@RequestMapping("/loginvalidation")
	public ModelAndView login(ServletRequest req,HttpSession sess) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Merchant m=dao.login(email, password);
		ModelAndView mv=new ModelAndView();
		
		if(m!=null) {
			mv.addObject("msg", "Successfully Login");
			mv.setViewName("merchantoptions");
			sess.setAttribute("merchantinfo", m);
			return mv;
		}else {
			mv.addObject("msg", "Invalid Credentials");
			mv.setViewName("merchantLoginForm");
			return mv;
		}
		
	}
}
