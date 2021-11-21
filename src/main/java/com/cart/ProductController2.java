package com.cart;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

//@SessionAttributes("customer")
@Controller
public class ProductController2 {
	ShoppingCart cart = new ShoppingCart();
	List<ProductCart> addtocartList = new ArrayList<>();
	List<Product> pList = new ArrayList<>();

	@RequestMapping(value = "/shop2")
	public String home(Model m) {
		// addtocartList = new ArrayList<>();
		ProductDao d = new ProductDao();
		pList = d.allProduct();
		m.addAttribute("products", pList);
		m.addAttribute("totalcategoryadded", cart.getTotalCategoryOfProduct());
		m.addAttribute("totalitemsadded", cart.getTotalNumberOfProduct());
		m.addAttribute("totalAmount", cart.getTotalAmount());
		return "shopcard";
	}

	// addtocart
	@RequestMapping(value = "/addtocart")
	public String addtocart(@ModelAttribute() ProductCart p, Model m) {
		// p.setQuantity(1);
		cart.addToCart(p);

		m.addAttribute("totalcategoryadded", cart.getTotalCategoryOfProduct());
		m.addAttribute("totalitemsadded", cart.getTotalNumberOfProduct());
		m.addAttribute("totalAmount", cart.getTotalAmount());
		ProductDao d = new ProductDao();
		m.addAttribute("products", d.allProduct());
		return "shopcard";
	}

	// increasecartitem
	@RequestMapping(value = "/increasecartitem")
	public String increasecartitem(@ModelAttribute() ProductCart p, Model m) {
		cart.addToCart(p);
		m.addAttribute("addtocartlist", cart.item);
		m.addAttribute("totalcategoryadded", cart.getTotalCategoryOfProduct());
		m.addAttribute("totalitemsadded", cart.getTotalNumberOfProduct());
		m.addAttribute("totalAmount", cart.getTotalAmount());
		return "addtocartpage";
	}

	// decreasecartitem
	@RequestMapping(value = "/decreasecartitem")
	public String decreasecartitem(@ModelAttribute() ProductCart p, Model m) {
		cart.removeFromCart(p);
		m.addAttribute("addtocartlist", cart.item);
		m.addAttribute("totalcategoryadded", cart.getTotalCategoryOfProduct());
		m.addAttribute("totalitemsadded", cart.getTotalNumberOfProduct());
		m.addAttribute("totalAmount", cart.getTotalAmount());
		return "addtocartpage";
	}

	@RequestMapping(value = "/addtocartpage")
	public String addtocartpage(Model m) {
		m.addAttribute("addtocartlist", cart.item);
		m.addAttribute("totalcategoryadded", cart.getTotalCategoryOfProduct());
		m.addAttribute("totalitemsadded", cart.getTotalNumberOfProduct());
		m.addAttribute("totalAmount", cart.getTotalAmount());
		return "addtocartpage";
	}

	// checkout
	@RequestMapping(value = "/checkout")
	public String checkout(Model m, HttpServletRequest req) {
//		m.addAttribute("addtocartlist", cart.item);
//		m.addAttribute("totalcategoryadded", cart.getTotalCategoryOfProduct());
//		m.addAttribute("totalitemsadded", cart.getTotalNumberOfProduct());
//		m.addAttribute("totalAmount", cart.getTotalAmount());
		req.getSession().setAttribute("addtocartlist", cart.item);
		req.getSession().setAttribute("totalAmount", cart.getTotalAmount());
		return "checkout";
	}

	// checkout
	@RequestMapping(value = "/createNewCustomerAccount")
	public String createAccount(Model m) {
//		m.addAttribute("addtocartlist", cart.item);
//		m.addAttribute("totalcategoryadded", cart.getTotalCategoryOfProduct());
//		m.addAttribute("totalitemsadded", cart.getTotalNumberOfProduct());
//		m.addAttribute("totalAmount", cart.getTotalAmount());
		return "createNewCustomerAccount";
	}

	// createcustomer
	@RequestMapping(value = "/createcustomer")
	public String createcustomer(Model m) {

		return "success";
	}

	// shipping

//	@RequestMapping(value = "/shipping")
//	public String shipping(Model m,@RequestParam String email) {
//        m.addAttribute("email", email); //to make sessionAttributes add to the class @SessionAttributes("email")
//		return "shipping";
//	}

	
	//using @SessionAttributes("customer")  at the controller to set the ModelAttribute** to the sessionscope
//	@RequestMapping(value = "/login")
//	public String shipping(Model m, @ModelAttribute() Customer c) {
//		CustomerDao dao = new CustomerDao();
//		Customer customerInDB = dao.userByEmailPassword(c.email, c.password);
//		//System.out.println(c);
//		if (customerInDB != null) {
//			m.addAttribute("customer", customerInDB);
//			//m.addAttribute("c", c); // to make sessionAttributes add to the class @SessionAttributes("c");
//			//System.out.println(customerInDB);
//			return "shipping";
//		}else {
//			m.addAttribute("errorIncorrectInfo", "IncorrectInfo please try again"); 
//			return "checkout";
//		}
//		//m.addAttribute("c", c); // to make sessionAttributes add to the class @SessionAttributes("c");
//		
//	}
	
	//using HttpSession to set the attribute to the sessionscope
	@RequestMapping(value = "/login")
	public String shipping(Model m, @ModelAttribute() Customer c, HttpServletRequest request) {
		CustomerDao dao = new CustomerDao();
		Customer customerInDB = dao.userByEmailPassword(c.email, c.password);
		//System.out.println(c);
		if (customerInDB != null) {
			 request.getSession().setAttribute("customer", customerInDB);
			 
			//session.setAttribute("customerInDB", customerInDB);  //to access th:value="${session.customerInDB.id}"
			//m.addAttribute("c", c); // to make sessionAttributes add to the class @SessionAttributes("c");
			System.out.println(customerInDB);
			return "shipping";
		}else {
			m.addAttribute("errorIncorrectInfo", "IncorrectInfo please try again"); 
			return "checkout";
		}
		//m.addAttribute("c", c); // to make sessionAttributes add to the class @SessionAttributes("c");
		
	}
	
	
	

	// payment
	@RequestMapping(value = "/payment")
	public String payment(Model m) {
		m.addAttribute("c", null); // to make sessionAttributes unavailable make it null ex: m.addAttribute("c",
									// null)
		return "payment";
	}

	// https://www.bkash.com/
	@RequestMapping(value = "/bikash")
	public String bkash(Model m) {

		return "redirect:" + "https://www.bkash.com/";
	}
}
