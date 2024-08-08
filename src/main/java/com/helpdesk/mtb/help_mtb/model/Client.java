package com.helpdesk.mtb.help_mtb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Client extends Common {

    private String name;
    private String phone;
    private String email;
    private String connection;

    @Column(name = "company_id")
    private Long companyId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    @JsonBackReference
    private Company company;

    public Client() {
    }
}
