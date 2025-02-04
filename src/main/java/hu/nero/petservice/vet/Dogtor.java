package hu.nero.petservice.vet;

import hu.nero.petservice.adoptions.DogAdoptionEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class Dogtor {

  @ApplicationModuleListener
  public void checkup(DogAdoptionEvent dogId) {
    System.out.println("checking up dog #" + dogId);
  }
}
