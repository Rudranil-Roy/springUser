package userservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import userservice.repository.UserRepository;

@Component
public class AuthServiceConsumer {
    private UserRepository userRepository;
    @Autowired
    AuthServiceConsumer(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Object eventData){
        try{
            System.out.println("hello");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
