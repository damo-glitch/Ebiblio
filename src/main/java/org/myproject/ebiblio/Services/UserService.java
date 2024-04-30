package org.myproject.ebiblio.Services;


import org.myproject.ebiblio.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserService {
    User saveUser(User user);

}
