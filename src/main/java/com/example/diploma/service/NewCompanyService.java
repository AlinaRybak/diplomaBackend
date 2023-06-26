package com.example.diploma.service;

import com.example.diploma.model.NewCompany;
import com.example.diploma.repository.NewCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewCompanyService {

    private final NewCompanyRepository newCompanyRepository;

    @Autowired
    public NewCompanyService(NewCompanyRepository newCompanyRepository) {
        this.newCompanyRepository = newCompanyRepository;
    }

    public NewCompany save(NewCompany newCompany) {
        return newCompanyRepository.save(newCompany);
    }

    public NewCompany getNewCompanyById(Long id) {
        return newCompanyRepository.findById(id).orElse(null);
    }

    public void deleteNewCompany(Long id) {
        newCompanyRepository.deleteById(id);
    }

}
