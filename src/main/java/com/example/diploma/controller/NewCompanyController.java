package com.example.diploma.controller;

import com.example.diploma.model.NewCompany;
import com.example.diploma.service.NewCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewCompanyController {
    private final NewCompanyService newCompanyService;

    @Autowired
    public NewCompanyController(NewCompanyService newCompanyService) {
        this.newCompanyService = newCompanyService;
    }

    @PostMapping("/about")
    public ResponseEntity<NewCompany> createNewCompany(@RequestBody NewCompany newCompany) {
        NewCompany savedNewCompany = newCompanyService.save(newCompany);
        return ResponseEntity.ok(savedNewCompany);
    }

    @GetMapping("/about")
    public ResponseEntity<List<NewCompany>> getCompanyInfo() {
        List<NewCompany> companyInfoList = newCompanyService.getCompanyInfo();
        return ResponseEntity.ok(companyInfoList);
    }
}
