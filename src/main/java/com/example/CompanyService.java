package com.example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> getCompanyInfo(String name){
        return companyRepository.findByName(name);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public void addCompany(Company company){
        if (companyRepository.findByName(company.getName()).isEmpty()){
            company.setFacebook("facebook");
            companyRepository.save(company);
        }
    }
}
