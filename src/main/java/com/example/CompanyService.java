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
//        if it is already in database, just return the info
        if (!companyRepository.findByDomain(domain).isEmpty()){
            return companyRepository.findByDomain(domain);
        }

        Parser parser = new Parser(domain);
        addCompany(Company.builder().
                domain(domain).
                facebook(parser.getFacebook()).
                twitter(parser.getTwitter()).
                icon(parser.getIcon()).
                build());
        return companyRepository.findByDomain(domain);
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public void addCompany(Company company) {
        Optional<Company> companyInDatabase = companyRepository.findByDomain(company.getDomain());
        if (!companyInDatabase.isEmpty()){
            companyRepository.deleteById(companyInDatabase.get().getId());
        }
        companyRepository.save(company);
    }
}
