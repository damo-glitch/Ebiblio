package org.myproject.ebiblio.Repositories;


import org.myproject.ebiblio.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    User findByEmail(String email);

    User findByPhoneNumber(String phoneNumber);
}
