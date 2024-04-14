package a1704569.CardCollection.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import a1704569.CardCollection.domain.CardRepository;
import a1704569.CardCollection.domain.Collection;
import a1704569.CardCollection.domain.CollectionRepository;
import a1704569.CardCollection.domain.CustomerRepository;


@Controller
public class CollectionController {
	
	@Autowired
	private CollectionRepository collectionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CardRepository cardRepository;
	
	
	@RequestMapping("/collectionlist")
	public String getcollections(Model model) {
		model.addAttribute("collections", collectionRepository.findAll());
		return "collectionlist";
	}
	
	@RequestMapping("/addcollection")
	public String addcollection (Model model) {
		model.addAttribute("collection", new Collection());
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("cards", cardRepository.findAll());
		return "/addcollection";
	}
	
	@RequestMapping(value = "/savecollection", method = RequestMethod.POST)
		public String savecollection(Collection collection) {
			collectionRepository.save(collection);
			return "redirect:collectionlist";
	}
	
	@RequestMapping(value = "/deletecollection/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deletecollection(@PathVariable("id") Long collectionId, Model model) {
		collectionRepository.deleteById(collectionId);
		return "redirect:/collectionlist";
	}
	@RequestMapping(value = "/collection/{id}")
		public String showModStu(@PathVariable("id") Long collectionid, Model model) {
		model.addAttribute("collection", collectionRepository.findById(collectionid));
		return "collection";
	}
	@RequestMapping(value = "/editcollection/{id}")
	@PreAuthorize("hasRole('ADMIN')")
		public String editCollection(@PathVariable("id") Long collectionId, Model model) {
		model.addAttribute("collection", collectionRepository.findById(collectionId)); 
		model.addAttribute("customers", customerRepository.findAll());
		model.addAttribute("cards", cardRepository.findAll());
		return "editcollection";
	}
	
}

