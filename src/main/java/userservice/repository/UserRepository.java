package userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import userservice.entities.UserInfoDto;

@Repository
public interface UserRepository extends CrudRepository<UserInfoDto, String> {
    UserInfoDto findByUserId(String userId);
}
