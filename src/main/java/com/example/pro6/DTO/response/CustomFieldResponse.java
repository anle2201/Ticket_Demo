package com.example.pro6.DTO.response;

import lombok.Data;

import java.sql.Timestamp;

public interface CustomFieldResponse {

    @Data
    class Detail {
        private Long id;

        private String name;

        private String key;

        private String fieldType;

        private Boolean isRequired;

        private String options;

        private Integer projectId;

        private Timestamp createdAt;

        private Timestamp updatedAt;
    }
   @Data
   class All{
       private Long id;

       private String name;

       private String key;

       private String fieldType;

       private Boolean isRequired;

       private String options;

       private Integer projectId;

       private Timestamp createdAt;

       private Timestamp updatedAt;

   }
}


