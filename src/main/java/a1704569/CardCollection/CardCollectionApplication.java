package a1704569.CardCollection;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import a1704569.CardCollection.domain.Card;
import a1704569.CardCollection.domain.CardRepository;
import a1704569.CardCollection.domain.Collection;
import a1704569.CardCollection.domain.CollectionRepository;
import a1704569.CardCollection.domain.Customer;
import a1704569.CardCollection.domain.CustomerRepository;
import a1704569.CardCollection.domain.Rarity;
import a1704569.CardCollection.domain.RarityRepository;

@SpringBootApplication
public class CardCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardCollectionApplication.class, args);
	}
	@Bean 
	public CommandLineRunner demo (
			CustomerRepository customerrepository,
			CardRepository cardrepository,
			RarityRepository rrepository,
			CollectionRepository collectionrepository) {
		
		return (args)->{
			Customer s0 = new Customer	("Teppo", "Testi", "email@testi.com", "050413242");
			Customer s1 = new Customer	("Tiina", "Testinen", "TiinaTestinen@testi.com", "040023123");
			
			customerrepository.save(s0);
			customerrepository.save(s1);
			
			Rarity r0 = new Rarity ("Common");
			Rarity r1 = new Rarity ("Uncommon");
			Rarity r2 = new Rarity ("Rare");
			Rarity r3 = new Rarity ("Unique");
			
			rrepository.save(r0);
			rrepository.save(r1);
			rrepository.save(r2);
			rrepository.save(r3);
			
			Card c0 = new Card ("Waterfalls of Ice", "Beautifully waterfall at the deep mountains",r2);
			Card c1 = new Card ("FireStorm", "Devasteting volcano eruption",r3);
			Card c2 = new Card ("Deep Sea", "So Deep that Light can't escape",r2);
		
			
			cardrepository.save(c0);
			cardrepository.save(c1);
			cardrepository.save(c2);
			
			Collection a1 = new Collection(s0,"TestiCollection", "Testataan toimiiko yhdistäminen",c0);
			Collection a2 = new Collection(s1,"UusiTestiColelction", "Tämänkin pitäisi toimia",c0);
			collectionrepository.save(a1);
			collectionrepository.save(a2);
			
		};
	}

}
