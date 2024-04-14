package a1704569.CardCollection.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a1704569.CardCollection.domain.Card;
import a1704569.CardCollection.domain.CardRepository;
import a1704569.CardCollection.domain.RarityRepository;


@Controller
public class CardController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@Autowired
	private RarityRepository rarityRepository;
	
	
	@RequestMapping("/cardlist")
	public String getCards(Model model) {
		model.addAttribute("cards", cardRepository.findAll());
		return "cardlist";
	}
	
	@RequestMapping("/addcard")
	@PreAuthorize("hasRole('ADMIN')")
	public String addcard (Model model) {
		model.addAttribute("card", new Card());
		model.addAttribute("rarities", rarityRepository.findAll());
		return "/addcards";
	}
	
	@RequestMapping(value = "savecard", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
		public String saveCard(Card card) {
			cardRepository.save(card);
			return "redirect:cardlist";
	}
	
	@RequestMapping(value = "/deletecard/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deletecard(@PathVariable("id") Long cardId, Model model) {
		cardRepository.deleteById(cardId);
		return "redirect:/cardlist";
	}
	
	@RequestMapping(value = "/editcard/{id}")
	@PreAuthorize("hasRole('ADMIN')")
		public String showModStu(@PathVariable("id") Long cardId, Model model) {
		model.addAttribute("card", cardRepository.findById(cardId)); 

		model.addAttribute("rarities", rarityRepository.findAll());
		return "editcard";
	}
}

