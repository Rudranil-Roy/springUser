package userservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import userservice.entities.UserInfo;
import userservice.entities.UserInfoDto;
import userservice.repository.UserRepository;
import userservice.service.UserService;

@Component
public class AuthServiceConsumer {
    @Autowired
    private UserService userService;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(UserInfoDto eventData){
        try{
            userService.createOrUpdateUser(eventData);
            System.out.println("hello");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
