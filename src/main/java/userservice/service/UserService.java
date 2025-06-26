package userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.entities.UserInfo;
import userservice.entities.UserInfoDto;
import userservice.repository.UserRepository;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserInfoDto createOrUpdateUser(UserInfoDto userInfoDto){
        UnaryOperator<UserInfo> updatingUser = user -> {
            // Todo: Implement Update Logic
            return userRepository.save(user);
        };

        Supplier<UserInfo> createUser = () -> {
            return userRepository.save(userInfoDto.transformToUserInfo());
        };

        UserInfo userInfo = userRepository.findByUserId(userInfoDto.getUserId())
                .map(updatingUser)
                .orElseGet(createUser);

        return UserInfoDto.builder()
                .userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .email(userInfo.getEmail())
                .phoneNumber(userInfo.getPhoneNumber())
                .profilePic(userInfo.getProfilePic())
                .build();
    }


    public UserInfoDto getUser(UserInfoDto userInfoDto) throws Exception{
        Optional<UserInfo> userInfoOpt = userRepository.findByUserId(userInfoDto.getUserId());
        if(userInfoOpt.isEmpty()){
            throw new Exception("User not found");
        }
        UserInfo userInfo= userInfoOpt.get();
        return UserInfoDto.builder()
                .userId(userInfo.getUserId())
                .firstName(userInfo.getFirstName())
                .lastName(userInfo.getLastName())
                .email(userInfo.getEmail())
                .phoneNumber(userInfo.getPhoneNumber())
                .profilePic(userInfo.getProfilePic())
                .build();
    }
}
