package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.model.Call;

import java.util.List;

public interface CallInterface {
    Call createCall(Call call);

    List<Call> getAllCalls();
}
