package com.example.icare.icare.controller;

import com.example.icare.icare.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping
public class MessageController {

    private final MessageService messageService;


}
