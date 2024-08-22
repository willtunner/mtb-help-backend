package com.helpdesk.mtb.help_mtb.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.helpdesk.mtb.help_mtb.dtos.CallDTO;
import com.helpdesk.mtb.help_mtb.dtos.ClientDTO;
import com.helpdesk.mtb.help_mtb.dtos.CompanyDTO;
import com.helpdesk.mtb.help_mtb.dtos.UserDTO;
import com.helpdesk.mtb.help_mtb.filters.CallFilter;
import com.helpdesk.mtb.help_mtb.model.Call;
import com.helpdesk.mtb.help_mtb.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CallService implements CallInterface {
    @Autowired
    private CallRepository callRepository;

    public CallDTO convertToDTO(Call call) {
        CallDTO dto = new CallDTO();
        dto.setId(call.getId());
        dto.setTitle(call.getTitle());
        dto.setDescription(call.getDescription());
        dto.setResolution(call.getResolution());
        dto.setTags(call.getTags());
        dto.setConnection(call.getConnection());
        dto.setClosed(call.getClosed());
        dto.setFinalized(call.getFinalized());
        dto.setCreated(call.getCreated());

        if (call.getCompany() != null) {
            CompanyDTO companyDTO = new CompanyDTO();
            companyDTO.setId(call.getCompany().getId());
            companyDTO.setName(call.getCompany().getName());
            dto.setCompany(companyDTO);
        }

        if (call.getClient() != null) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(call.getClient().getId());
            clientDTO.setName(call.getClient().getName());
            dto.setClient(clientDTO);
        }

        if (call.getEmployee() != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(call.getEmployee().getId());
            userDTO.setName(call.getEmployee().getName());
            dto.setEmployee(userDTO);
        }

        return dto;
    }

    @Override
    public Call createCall(Call call) {
        return callRepository.save(call);
    }

    @Override
    public List<CallDTO> getAllCalls() {
        List<Call> calls = callRepository.findAll();
        return calls.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

//    @Override
//    public List<Call> filterCalls(CallFilter filter) {
//        return callRepository.findAll(CallSpecification.filterBy(filter));
//    }

    public List<Call> filterCalls(CallFilter filterDTO) {
        return callRepository.findByFilter(filterDTO);
    }

    @Override
    public String executeAnyDesk(String connectionString) {
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

    @Override
    public boolean deleteCall(Long id) {
        // Verifica se o Call existe pelo ID
        if (callRepository.existsById(id)) {
        // Se existir, realiza a exclusão
            callRepository.deleteById(id);
            return true; // Retorna true se foi deletado com sucesso
        } else {
            return false; // Retorna false se não encontrou o Call
        }
    }


}
