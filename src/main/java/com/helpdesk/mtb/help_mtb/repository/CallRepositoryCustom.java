package com.helpdesk.mtb.help_mtb.repository;

import com.helpdesk.mtb.help_mtb.filters.CallFilter;
import com.helpdesk.mtb.help_mtb.model.Call;

import java.util.List;

public interface CallRepositoryCustom {
    List<Call> findByFilter(CallFilter filter);
}
