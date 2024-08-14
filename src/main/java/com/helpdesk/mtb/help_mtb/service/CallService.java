package com.helpdesk.mtb.help_mtb.service;

import com.helpdesk.mtb.help_mtb.filters.CallFilter;
import com.helpdesk.mtb.help_mtb.filters.CallSpecification;
import com.helpdesk.mtb.help_mtb.model.Call;
import com.helpdesk.mtb.help_mtb.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService implements CallInterface {
    @Autowired
    private CallRepository callRepository;

    @Override
    public Call createCall(Call call) {
        return callRepository.save(call);
    }

    @Override
    public List<Call> getAllCalls() {
        return callRepository.findAll();
    }

    @Override
    public List<Call> filterCalls(CallFilter filter) {
        Specification<Call> spec = new CallSpecification(filter);
        return callRepository.findAll(spec);
    }


}
