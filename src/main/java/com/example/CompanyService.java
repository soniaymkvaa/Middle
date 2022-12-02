package com.example;

import com.example.parser.Parser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Optional<Company> getCompanyInfo(String domain) throws IOException {
        addCompany(Company.builder().domain(domain).build());
        return companyRepository.findByDomain(domain);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public void addCompany(Company company) throws IOException {
        if (companyRepository.findByDomain(company.getDomain()).isEmpty()){
            Parser parser = new Parser(company.getDomain());
            company.setFacebook(parser.getFacebook());
            company.setTwitter(parser.getTwitter());
            company.setIcon(parser.getIcon());
            companyRepository.save(company);
        }
    }
}
