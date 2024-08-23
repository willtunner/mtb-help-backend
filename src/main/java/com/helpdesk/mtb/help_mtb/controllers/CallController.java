package com.helpdesk.mtb.help_mtb.controllers;

import com.helpdesk.mtb.help_mtb.dtos.CallDTO;
import com.helpdesk.mtb.help_mtb.filters.CallFilter;
import com.helpdesk.mtb.help_mtb.model.Call;
import com.helpdesk.mtb.help_mtb.service.CallService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return callService.createCall(call);
    }

    @GetMapping
    public List<CallDTO> getAllCalls() {
        return callService.getAllCalls();
    }

    @GetMapping("/execute")
    public String executeCommand(@RequestParam String connectionString) {
        return callService.executeAnyDesk(connectionString);
    }

    @PostMapping("/filter")
    public List<Call> filterCalls(@RequestBody CallFilter filterDTO) {
        return callService.filterCalls(filterDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCall(@PathVariable Long id) {
        boolean isDeleted = callService.deleteCall(id);

        if (isDeleted) {
            return ResponseEntity.ok(true); // Retorna 200 OK com true se o chamado foi deletado
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false); // Retorna 404 Not Found com false se o chamado não foi encontrado
        }
    }
}
