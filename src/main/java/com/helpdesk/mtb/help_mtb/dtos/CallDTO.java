package com.helpdesk.mtb.help_mtb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CallDTO {
    private Long id;
    private String title;
    private String description;
    private String resolution;
    private String tags;
    private String connection;
    private Boolean closed;
    private LocalDateTime finalized;

    private CompanyDTO company;
    private ClientDTO client;
    private UserDTO employee;

    public CallDTO() {

    }
}
