package com.example.apisuperrecette.models.user;

import com.example.apisuperrecette.models.user.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserInfo, Integer> {

    UserInfo findOneByEmail(String email);

}
