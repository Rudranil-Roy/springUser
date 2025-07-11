package userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfoDto {
    Long id;
    //@JsonProperty("user_Id")
    //@NonNull
    private String userId;
    //@JsonProperty("first_name")
    //@NonNull
    private String firstName;
    //@JsonProperty("last_name")
    //@NonNull
    private String lastName;
    //@JsonProperty("email")
    //@NonNull
    private String email;
    //@JsonProperty("phone_number")
    //@NonNull
    private Long phoneNumber;
    //@JsonProperty("profile_pic")
    private String profilePic;

    public UserInfo transformToUserInfo(){
        return UserInfo.builder()
                .userId(userId)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phoneNumber(phoneNumber)
                .profilePic(profilePic)
                .build();
    }
}
