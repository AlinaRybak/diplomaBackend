package com.example.diploma.repository;

import com.example.diploma.model.NewCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewCompanyRepository extends JpaRepository<NewCompany, Long> {
}
