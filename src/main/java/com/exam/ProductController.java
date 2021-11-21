package com.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	List<CartProduct> addtocartList = new ArrayList<>();
	// Set<CartProduct> addtocartSet = new HashSet<>();
	boolean match;
	//toget net price
	double netTotal=0.0;
	
	List<Product> pList = new ArrayList<>();

	@RequestMapping(value = "/shop")
	public String home(Model m) {
		// addtocartList = new ArrayList<>();
		ProductDa d = new ProductDa();
		// to show added quantity in page
		int totalcategoryadded = 0;
		int totalitemsadded = 0;
		for (CartProduct pd : addtocartList) {
			totalcategoryadded = totalcategoryadded + 1;
			totalitemsadded = totalitemsadded + pd.getQuantityadded();

		}
		m.addAttribute("totalcategoryadded", totalcategoryadded);
		m.addAttribute("totalitemsadded", totalitemsadded);

		pList = d.allProduct();
		m.addAttribute("products", pList);
		return "shop";
	}

//	@RequestMapping(value = "/addtocart")
//	public String addtocart(@ModelAttribute() Product p,Model m) {
//		ProductDa d = new ProductDa();
//		addtocartList.add(p);
//		m.addAttribute("addtocartsize", addtocartList.size());
//		pList = d.allProduct();
//		m.addAttribute("products", pList);
//		return "shop";
//	}

	// addtocart
	@RequestMapping(value = "/addtocart")
	public String addtocart(@ModelAttribute() CartProduct p, Model m) {
		// addtocartList = new ArrayList<>();
		for (CartProduct pd : addtocartList) {
			if (pd.getId() == p.id) {
				pd.setQuantityadded(pd.getQuantityadded() + 1);
				match = true;
				break;
			} else {
				match = false;
			}

		}
		if (addtocartList.size() == 0 || match == false) {
			p.setQuantityadded(p.getQuantityadded() + 1);
			addtocartList.add(p);
		}
		int totalcategoryadded = 0;
		int totalitemsadded = 0;
		//double netTotal=0.0;
		for (CartProduct pd : addtocartList) {
			totalcategoryadded = totalcategoryadded + 1;
			totalitemsadded = totalitemsadded + pd.getQuantityadded();

		}
		netTotal=0;
		for(CartProduct pd : addtocartList) {
			netTotal+=(pd.price * pd.quantityadded);
		}
		
		m.addAttribute("totalcategoryadded", totalcategoryadded);
		m.addAttribute("totalitemsadded", totalitemsadded);
		m.addAttribute("netTotal", netTotal);
		ProductDa d = new ProductDa();
		m.addAttribute("products", d.allProduct());
		return "shop";
	}

	// increasecartitem
	@RequestMapping(value = "/increasecartitem")
	public String increasecartitem(@ModelAttribute() CartProduct p, Model m) {
		for (CartProduct pd : addtocartList) {
			if (pd.getId() == p.id) {
				pd.setQuantityadded(pd.getQuantityadded() + 1);
				match = true;
				break;
			} else {
				match = false;
			}

		}

		if (match == false) {
			p.setQuantityadded(p.getQuantityadded() + 1);
			addtocartList.add(p);
		}

		// for showing totalcategoryadded
		int totalcategoryadded = 0;
		int totalitemsadded = 0;
		for (CartProduct pd : addtocartList) {
			totalcategoryadded = totalcategoryadded + 1;
			totalitemsadded = totalitemsadded + pd.getQuantityadded();
		}
		
		netTotal=0;
		for(CartProduct pd : addtocartList) {
			netTotal+=(pd.price * pd.quantityadded);
		} 
		
		m.addAttribute("totalcategoryadded", totalcategoryadded);
		m.addAttribute("totalitemsadded", totalitemsadded);
		m.addAttribute("netTotal", netTotal);
		// ProductDa d = new ProductDa();
		// m.addAttribute("products", d.allProduct());

		m.addAttribute("addtocartlist", addtocartList);
		return "addtocartpage";
	}

	// decreasecartitem
	@RequestMapping(value = "/decreasecartitem")
	public String decreasecartitem(@ModelAttribute() CartProduct p, Model m) {
		for (CartProduct pd : addtocartList) {
			if (pd.getId() == p.id && addtocartList.size() > 0) {
				pd.setQuantityadded(pd.getQuantityadded() - 1);
				if (pd.getQuantityadded() == 0) {
					addtocartList.remove(pd);
				}
				match = true;
				break;
			}

		}

		// for showing totalcategoryadded
//			int totalcategoryadded=0;
//			int totalitemsadded=0;
//			for (CartProduct pd : addtocartList) {
//				totalcategoryadded=totalcategoryadded+1;
//				totalitemsadded=totalitemsadded+pd.getQuantityadded();
//			}
//			m.addAttribute("totalcategoryadded",totalcategoryadded);
//			m.addAttribute("totalitemsadded",totalitemsadded);

		// ProductDa d = new ProductDa();
		// m.addAttribute("products", d.allProduct());
		netTotal=0;
		for(CartProduct pd : addtocartList) {
			netTotal=(pd.price * pd.quantityadded)+netTotal;
		} 
		
		m.addAttribute("addtocartlist", addtocartList);
		m.addAttribute("netTotal", netTotal);
		return "addtocartpage";
	}

	@RequestMapping(value = "/addtocartpage")
	public String addtocartpage(Model m) {
		m.addAttribute("addtocartlist", addtocartList);
		m.addAttribute("netTotal", netTotal);
		return "addtocartpage";
	}
}
