package com.example.icare.icare.service;

import com.example.icare.icare.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class AdminService {
    private final AdminRepository adminRepository;

}
