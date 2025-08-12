package com.example.pro6.DTO.request;

import lombok.Data;

import java.sql.Timestamp;

public interface CustomFieldRequest {

    @Data
    class CreateCustomField {

        private Integer projectId;

        private String name;

        private String key;

        private String fieldType;

        private Boolean isRequired;

        private String options;

        private Timestamp createdAt;

        private Timestamp updatedAt;

        private Boolean isDeleted = false;

    }
}
