package a1704569.CardCollection.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import a1704569.CardCollection.domain.Customer;
import a1704569.CardCollection.domain.CustomerRepository;


@Controller
public class CustomerController {

	@Autowired
	private CustomerRepository crepository;
	
	
	@RequestMapping("/customerlist")
	public String getCustomers(Model model) {
		model.addAttribute("customers", crepository.findAll());
		return "customerlist";
	}
	
	@RequestMapping("/add")
	public String addCustomer (Model model) {
		model.addAttribute("customer", new Customer());
		return "/addcustomer";
	}
	
	@RequestMapping(value = "/savecustomer", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
		public String saveCustomer(Customer customer) {
			crepository.save(customer);
			return "redirect:customerlist";
	}
	
	@RequestMapping(value = "/deletecustomer/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteCustomer(@PathVariable("id") Long customerId, Model model) {
		crepository.deleteById(customerId);
		return "redirect:/customerlist";
	}
	@RequestMapping(value = "/editcustomer/{id}")
	@PreAuthorize("hasRole('ADMIN')")
		public String editCustomer(@PathVariable("id") Long customerId, Model model) {
		model.addAttribute("customer", crepository.findById(customerId)); 
		return "editcustomer";
	}
	
}

	

