package userservice.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import userservice.entities.UserInfoDto;

import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public UserInfoDto deserialize(String arg0, byte[] data){
        ObjectMapper objectMapper= new ObjectMapper();
        UserInfoDto user=null;
        try{
            user= objectMapper.readValue(data, UserInfoDto.class);
        } catch (Exception ex) {
            System.out.println("Cannot Deserialize");
        }
        return user;
    }

    @Override
    public void close(){}
}
