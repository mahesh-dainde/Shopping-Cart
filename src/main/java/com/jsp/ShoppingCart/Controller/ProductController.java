package com.jsp.ShoppingCart.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.ShoppingCart.dao.MerchantDAO;
import com.jsp.ShoppingCart.dao.ProductDAO;
import com.jsp.ShoppingCart.dto.Merchant;
import com.jsp.ShoppingCart.dto.Product;

@Controller
public class ProductController {
	
	@Autowired
	ProductDAO dao;
	
	@Autowired
	MerchantDAO merchantDAO;
	
	@RequestMapping("/addproduct")
	public ModelAndView addproduct() {
		
		Product p=new Product();
		ModelAndView view=new ModelAndView();
		view.addObject("productobj",p);
		view.setViewName("productform");
		
		return view;
	}
	@RequestMapping("/saveproduct")
	public ModelAndView saveproduct(@ModelAttribute("productobj") Product p,HttpSession session) {
		Merchant merchant=(Merchant) session.getAttribute("merchantinfo");
		List<Product> products=merchant.getProducts();
		
		if(products.size()>0)
		{
			products.add(p);
			merchant.setProducts(products);
		}
		else
		{
			List<Product> productslist=new ArrayList<>();
			productslist.add(p);
			merchant.setProducts(productslist);
		}
		
		dao.saveProduct(p);
		merchantDAO.updateMerchant(merchant);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("msg", "Product saved Successfully");
		modelAndView.setViewName("merchantoptions");
		
		return modelAndView;
	}
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("id") int id ,HttpSession session) {
		Merchant merchant=(Merchant)session.getAttribute("merchantinfo");
		
		Merchant m=merchantDAO.deleteProductFromMerchant(merchant.getId(), id);
		
		merchantDAO.updateMerchant(m);
		dao.deleteProductById(id);
		
		session.setAttribute("merchantinfo", m);
		
		ModelAndView modelAndView =new ModelAndView();
		modelAndView.setViewName("viewallproducts");
		
		return modelAndView;
	}
	@RequestMapping("/updateproduct")
	public ModelAndView updateProduct(@RequestParam("id") int id,HttpSession session) {
		
		Merchant merchant=(Merchant)session.getAttribute("merchantinfo");
		
		Product product=(Product)merchant.getProducts();
		
		dao.updateProduct(product);
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("viewallproducts");
		
		return mav;
		
	}
	@RequestMapping("/displayproducts")
	public ModelAndView displayproducts() {
		List<Product> products=dao.fetchAllProducts();
		ModelAndView mav=new ModelAndView();
		mav.addObject("productlist",products);
		mav.setViewName("viewallproductstocustomer");
		
		return mav;
	}
	@RequestMapping("/displayproductbybrand")
	public ModelAndView displayProductByBrand(ServletRequest request) {
		String brand=request.getParameter("brand");
		List<Product> products=dao.findProductByBrand(brand);
		ModelAndView mav=new ModelAndView();
		mav.addObject("productlist", products);
		mav.setViewName("viewallproductstocustomer");
		
		return mav;
	}

}
