package com.example.icare.icare.controller;

import com.example.icare.icare.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/report")
public class ReportController {
    private final ReportService reportService;
@Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
}
