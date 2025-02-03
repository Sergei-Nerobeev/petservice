package hu.nero.petservice.adoptions;

import hu.nero.petservice.entity.Dog;
import hu.nero.petservice.vet.Dogtor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@Transactional
@ResponseBody
public class DogAdoptionController {

  private final DogRepository repository;
  private final Dogtor dogtor;

  @Autowired
  public DogAdoptionController(DogRepository repository, Dogtor dogtor) {
    this.repository = repository;
    this.dogtor = dogtor;
  }

  @PostMapping("/dogs/{dogId}/adoptions")
  void adopt(
      @PathVariable Integer dogId,
      @RequestBody Map<String, String> owner) {

    repository.findById(dogId).ifPresent(dog -> {
      var newDog = this.repository.save(
          new Dog(
              dogId,
              dog.getName(),
              dog.getDescription(),
              owner.get("name")
          ));
      this.dogtor.checkup(dogId);
      System.out.println("adopted [ " + newDog + "]");
    });

  }

}

interface DogRepository extends ListCrudRepository<Dog, Integer> {

}

//record Dog(int id, String name, String description, String owner) {
//
//}
