package productcrudapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class MainController {

	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	//show add Product Form
	@RequestMapping("/addProduct")
	public String addProduct()
	{
		return "add_Product_Form";
	}
	
	//handle add Product Form
	@RequestMapping(value="/handleForm",method=RequestMethod.POST)
	public RedirectView handleAddProduct(@ModelAttribute("product") Product product,HttpServletRequest request)
	{
		
		System.out.println(product);
		this.productDao.createProduct(product);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		
		
		return redirectView;
	}
	
	//delete Product
	@RequestMapping("/delete/{id}")
	public RedirectView deleteProduct(@PathVariable("id") int id,HttpServletRequest request)
	{
		
		this.productDao.deleteProduct(id);
		
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		
		return redirectView;
	}
	
	
	//Update the Product
	@RequestMapping("/update/{id}")
	public String updateProduct(@PathVariable("id") int id,Model model)
	{
		Product product=this.productDao.getProduct(id);
		return "updateForm";
	}
	
}
