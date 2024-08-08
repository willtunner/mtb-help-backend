package com.helpdesk.mtb.help_mtb.controllers;

import com.helpdesk.mtb.help_mtb.model.Call;
import com.helpdesk.mtb.help_mtb.service.CallService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call")
@CrossOrigin
@RequiredArgsConstructor
@Slf4j
public class CallController {

    @Autowired
    private CallService callService;

    @PostMapping
    public Call createCall(@RequestBody Call call) throws MessagingException {
        call.setClosed(false);
        return callService.createCall(call);
    }

    @GetMapping
    public List<Call> getAllCalls() {

        return callService.getAllCalls();
    }
}
