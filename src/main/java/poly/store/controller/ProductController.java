package poly.store.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.store.entity.Product;
import poly.store.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService pService;
	
	@RequestMapping("/product/list")
	public String list(Model m, @RequestParam("cid") Optional<String> cid) {
		if(cid.isPresent()) {
			List<Product> list = pService.findByCategoryId(cid.get());
			m.addAttribute("items", list);
		}
		else {
			List<Product> list = pService.findAll();
			m.addAttribute("items", list);
		}
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
	public String detail(Model m, @PathVariable("id") Integer id) {
		Product item = pService.findById(id);
		m.addAttribute("item", item);
		return "product/detail";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "layout/index";
	}
}
