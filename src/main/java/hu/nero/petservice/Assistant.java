package hu.nero.petservice;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Assistant {

  @Bean
  ChatClient client(ChatClient.Builder builder) {
    return builder.build();
  }
  @Bean
  ApplicationRunner demo(ChatClient client) {
    return args -> {
      var content = client
          .prompt("do you have any energetic dogs?")
          .call()
          .content();
      System.out.println("content [" + content + "]");

    };
  }

}
