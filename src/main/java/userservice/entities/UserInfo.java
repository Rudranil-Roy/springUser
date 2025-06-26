package userservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
    @Id
    //@JsonProperty("user_Id")
    private String userId;
    //@JsonProperty("first_name")
    private String firstName;
    //@JsonProperty("last_name")
    private String lastName;
    //@JsonProperty("email")
    private String email;
    //@JsonProperty("phone_number")
    private Long phoneNumber;
    //@JsonProperty("profile_pic")
    private String profilePic;
}
