package com.example.pro6.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "custom_fields")

public class CustomField {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "project_id",nullable = true)
        private Integer projectId;

        @Column(name = "name",nullable = true)
        private String name;

        @Column(name = "key",unique = true, nullable = true)
        private String key;

        @Column(nullable = false,name = "field_type")
        private String fieldType;

        @Column(name = "is_required")
        private Boolean isRequired;

        @Column(nullable = false,name = "options")
        private String options;

        @Column(name = "is_deleted")
        private Boolean isDeleted = false;

        @Column(name = "created_at")
        private Timestamp createdAt;

        @Column(name = "updated_at")
        private Timestamp updatedAt;

}


