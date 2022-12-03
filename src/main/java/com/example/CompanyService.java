package com.example;

import com.example.merger.Merger;
import com.example.parser.Parser;
import com.mashape.unirest.http.exceptions.UnirestException;
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

    public Optional<Company> getCompanyInfo(String domain) throws IOException, UnirestException, InterruptedException {
        if (companyRepository.findByDomain(domain).isEmpty()){
            Merger merger = new Merger(domain);
            addCompany(merger.getCompany());
        }
        return companyRepository.findByDomain(domain);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public void addCompany(Company company) {
//        Optional<Company> companyInDatabase = companyRepository.findByDomain(company.getDomain());
//        if (!companyInDatabase.isEmpty()){
//            companyRepository.deleteById(companyInDatabase.get().getId());
//        }
        companyRepository.save(company);
    }
}
