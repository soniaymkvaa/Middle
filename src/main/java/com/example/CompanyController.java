package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/v1/company")
@RestController
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "/{companyDomain}")
    public Optional<Company> getCompanyInfo(@PathVariable("companyDomain") String domain) throws IOException {
        return companyService.getCompanyInfo(domain);
    }

    @GetMapping
    public List<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @PostMapping
    public void addCompany(@RequestBody Company company) throws IOException {
        companyService.addCompany(company);
    }
}
