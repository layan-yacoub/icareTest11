package com.example.icare.icare.repository;

import com.example.icare.icare.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository//JPA Repository is mainly used for managing the data in a Spring Boot Application
public interface MessageRepository extends JpaRepository<Message, Long> {



}
