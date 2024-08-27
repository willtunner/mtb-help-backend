package com.helpdesk.mtb.help_mtb.controllers;

import com.helpdesk.mtb.help_mtb.model.Company;
import com.helpdesk.mtb.help_mtb.model.User;
import com.helpdesk.mtb.help_mtb.service.CompanyService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody Company company) throws MessagingException {
        return companyService.createCompany(company);
    }

    @GetMapping
    public List<Company> getAllCompany() {
        return companyService.getAllCompany();
    }

    @PostMapping("/{companyId}/addUser/{userId}")
    public Company addUserToCompany(@PathVariable Long companyId, @PathVariable Long userId) {
        return companyService.addUserToCompany(companyId, userId);
    }

    @GetMapping("/api/companies/search")
    public List<Company> searchCompanies(@RequestParam String name) {
        return companyService.findByNameContainingIgnoreCase(name);
    }
}
