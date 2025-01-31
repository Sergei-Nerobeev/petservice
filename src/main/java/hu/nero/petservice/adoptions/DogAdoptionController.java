package hu.nero.petservice.adoptions;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
public class DogAdoptionController {

  private final DogRepository repository;

  public DogAdoptionController(DogRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/dogs/{dogId}/adoptions")
  void adopt(
      @PathVariable Integer dogId,
      @RequestBody Map<String, String> owner) {

    repository.findById(dogId).ifPresent(dog -> {
      var newDog = this.repository.save(new Dog(dogId, dog.name(), dog.description(), owner.get("name")));
      System.out.println("adopted [ " + newDog + "]");
    });

  }

}

interface DogRepository extends ListCrudRepository<Dog, Integer> {

}

record Dog(int id, String name, String description, String owner) {

}
