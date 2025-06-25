package userservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import userservice.repository.UserRepository;

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
