package a1704569.CardCollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import a1704569.CardCollection.web.CardController;
import a1704569.CardCollection.web.CollectionController;
import a1704569.CardCollection.web.CustomerController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CardCollectionApplicationTests {
	
	@Autowired
	private CollectionController collectionController;
	
	@Autowired
	private CardController cardController;
	
	@Autowired
	private CustomerController customerController;

	@Test
	public void collectioncontextLoads() {
		assertThat(collectionController).isNotNull();
	}
	@Test
	public void cardcontextLoads() {
		assertThat(cardController).isNotNull();
	}
	@Test
	public void customercontextLoads() {
		assertThat(customerController).isNotNull();
	}

}
