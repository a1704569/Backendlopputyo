package a1704569.CardCollection.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface CardRepository extends CrudRepository<Card, Long> {
	
}
