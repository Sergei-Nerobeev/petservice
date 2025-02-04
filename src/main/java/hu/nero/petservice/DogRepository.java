package hu.nero.petservice;

import hu.nero.petservice.entity.Dog;
import org.springframework.data.repository.ListCrudRepository;

public interface DogRepository extends ListCrudRepository<Dog, Integer> {
}
