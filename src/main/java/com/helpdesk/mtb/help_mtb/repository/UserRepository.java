package com.helpdesk.mtb.help_mtb.repository;

import com.helpdesk.mtb.help_mtb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
}
