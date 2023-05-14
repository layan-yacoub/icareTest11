package com.example.icare.icare.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //JPA Repository is mainly used for managing the data in a Spring Boot Application
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findUserByEmail(String email);
    Boolean existsByEmail(String email);

}
