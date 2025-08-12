package com.example.pro6.Repository;


import com.example.pro6.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM tickets WHERE is_deleted = false ")
    Optional<Ticket> findByIdAndIsDeletedFalse(Long id);


    @Query(value =
            "SELECT * FROM tickets " +
                    "WHERE (:business IS NULL OR business ILIKE '%' || :business || '%') " +
                    "  AND (:status IS NULL OR status ILIKE '%' || :status || '%') " +
                    "  AND (:priority IS NULL OR priority ILIKE '%' || :priority || '%') " +
                    "  AND (:giveTo IS NULL OR give_to ILIKE '%' || :giveTo || '%') " +
                    "  AND (:serialNumber IS NULL OR serial_number ILIKE '%' || :serialNumber || '%') " +
                    "  AND is_deleted = false",
            nativeQuery = true)
    List<Ticket> searchAll(@Param("business") String business,
                           @Param("status") String status,
                           @Param("priority") String priority,
                           @Param("giveTo") String giveTo,
                           @Param("serialNumber") String serialNumber
    );


    boolean existsBySerialNumber(String serialNumber);

    @Query(nativeQuery = true, value = "SELECT * FROM tickets WHERE status ILIKE %:keySearch% AND is_deleted = false LIMIT :limit OFFSET :offset ")
    List<Ticket> findByStatus(Integer offset, Integer limit, String keySearch);

}

