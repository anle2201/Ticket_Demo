package com.example.pro6.Repository;

import com.example.pro6.Model.CustomField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomFieldRepository extends JpaRepository<CustomField, Long> {
    Optional<CustomField> findById (Long id);

    Optional<CustomField> findByIdAndIsDeletedFalse(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM custom_fields WHERE is_deleted = false")
    List<CustomField> findAll();
}
