package com.helpdesk.mtb.help_mtb.repository;

import com.helpdesk.mtb.help_mtb.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<Call, Long>, JpaSpecificationExecutor<Call> {

    @Query("SELECT c FROM Call c WHERE " +
            "( :companyId IS NULL OR c.companyId = :companyId ) AND " +
            "( :clientId IS NULL OR c.clientId = :clientId ) AND " +
            "( :title IS NULL OR LOWER(c.title) LIKE LOWER(CONCAT('%', :title, '%')) ) AND " +
            "( :description IS NULL OR LOWER(c.description) LIKE LOWER(CONCAT('%', :description, '%')) ) AND " +
            "( :resolution IS NULL OR LOWER(c.resolution) LIKE LOWER(CONCAT('%', :resolution, '%')) ) AND " +
            "( :tags IS NULL OR LOWER(c.tags) LIKE LOWER(CONCAT('%', :tags, '%')) ) AND " +
            "( :closed IS NULL OR c.closed = :closed ) AND " +
            "( :created IS NULL OR c.created >= :created ) AND " +
            "( :finalized IS NULL OR c.finalized <= :finalized )")
    List<Call> filterCalls(@Param("companyId") Long companyId,
                           @Param("clientId") Long clientId,
                           @Param("title") String title,
                           @Param("description") String description,
                           @Param("resolution") String resolution,
                           @Param("tags") String tags,
                           @Param("closed") Boolean closed,
                           @Param("created") LocalDateTime created,
                           @Param("finalized") LocalDateTime finalized);

}
