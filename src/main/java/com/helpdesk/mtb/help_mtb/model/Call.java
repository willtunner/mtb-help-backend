package com.helpdesk.mtb.help_mtb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class Call extends Common {

    @Column(name = "company_id")
    private Long companyId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    @Column(name = "client_id")
    private Long clientId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Client client;

    @Column(name = "employee_id")
    private Long employeeId;
    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private User employee;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "TEXT")
    private String resolution;
    private String tags;
    private String connection;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private Boolean closed = Boolean.FALSE;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime finalized; //= LocalDateTime.now();

    public Call() {
    }
}
