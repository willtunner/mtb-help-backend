package com.helpdesk.mtb.help_mtb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Company extends Common {

    private String name;
    private String cnpj;
    private String city;
    private String state;
    private String address;
    private String zipcode;
    private String phone;
    private String connectionServ;
    private String email;
    private String versionServ;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Client> clients;

    public Company() {
    }
}
