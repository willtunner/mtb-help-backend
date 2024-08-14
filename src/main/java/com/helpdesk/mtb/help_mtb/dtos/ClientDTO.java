package com.helpdesk.mtb.help_mtb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String name;

    public ClientDTO() {

    }
}
