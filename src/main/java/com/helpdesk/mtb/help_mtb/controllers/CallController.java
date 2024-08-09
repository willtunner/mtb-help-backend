package com.helpdesk.mtb.help_mtb.controllers;

import com.helpdesk.mtb.help_mtb.model.Call;
import com.helpdesk.mtb.help_mtb.service.CallService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/execute")
    public String executeCommand(@RequestParam String connectionString) {
        // Escapamento básico para evitar injeção de comando
        if (connectionString.contains("&&") || connectionString.contains("|") || connectionString.contains(";")) {
            return "Comando inválido.";
        }

        String command = String.format("\"C:\\Program Files (x86)\\AnyDesk\\AnyDesk.exe\" %s", connectionString);
        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            return "Comando executado com sucesso.";
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Erro ao executar o comando.";
        }
    }
}
