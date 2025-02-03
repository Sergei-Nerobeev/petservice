package hu.nero.petservice.vet;

import org.springframework.stereotype.Service;

@Service
public class Dogtor {

  public void checkup(int dogId) {
    System.out.println("checking up dog #" + dogId);
  }
}
