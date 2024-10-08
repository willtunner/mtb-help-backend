package com.helpdesk.mtb.help_mtb.filters;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CallFilter {
    private Long companyId;
    private Long clientId;
    private String connection;
    private String title;
    private String description;
    private String resolution;
    private String tags;
    private Boolean closed;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    public CallFilter() {

    }
}
