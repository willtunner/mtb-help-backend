package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.dtos.CallDTO;
import com.helpdesk.mtb.help_mtb.filters.CallFilter;
import com.helpdesk.mtb.help_mtb.model.Call;

import java.util.List;

public interface CallInterface {
    Call createCall(Call call);

    List<CallDTO> getAllCalls();

    String executeAnyDesk(String connection);

    boolean deleteCall(Long id);
}
