package com.example.icare.icare.service;

import com.example.icare.icare.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageService {
    @Autowired
    private final MessageRepository messageRepository;

}
