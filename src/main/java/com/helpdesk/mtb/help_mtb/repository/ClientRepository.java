package com.helpdesk.mtb.help_mtb.repository;

import com.helpdesk.mtb.help_mtb.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
