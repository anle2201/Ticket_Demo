package com.example.pro6.Repository;

import com.example.pro6.Model.TicketMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TicketMessageRepository extends JpaRepository<TicketMessage, Long> {
    Optional<TicketMessage> findByTicketId(Long ticketId);

    Optional<TicketMessage> findById(Long id);

    @Query(value =
            "SELECT * FROM ticket_message " +
                    "WHERE (:CCs IS NULL OR CCs ILIKE '%' || :CCs || '%') " +
                    "  AND (:status IS NULL OR status ILIKE '%' || :status || '%') " +
                    "  AND (:priority IS NULL OR priority ILIKE '%' || :priority || '%') " +
                    "  AND (:giveTo IS NULL OR give_to ILIKE '%' || :giveTo || '%') " +
                    "  AND (:typeAccident IS NULL OR type_accident ILIKE '%' || :typeAccident || '%') " +
                    "  AND is_deleted = false",
            nativeQuery = true)
    List<TicketMessage> searchAll(
            String CCs,
            String status,
            String priority,
            String giveTo,
            String typeAccident);

}

