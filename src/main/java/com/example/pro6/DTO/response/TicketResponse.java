package com.example.pro6.DTO.response;

import com.example.pro6.Model.Ticket;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

public interface TicketResponse {
    @Data
    class AllWithMessages {
        private String serialNumber;

        private String name;

        private String giveTo;

        private String contact;

        private String business;

        public enum Priority {
            low, normal, high, urgent
        }

        public enum Status {
            moi, dong
        }

        @Enumerated(EnumType.STRING)
        private Ticket.Status status;

        @Enumerated(EnumType.STRING)
        private Ticket.Priority priority;

        private String createdByCode;

        private String assignedToCode;

        private Timestamp createdAt;

        private Timestamp updatedAt;

        private String projectCode;

        List<TicketMessageResponse.All> messages;

    }
    @Data
    class All{
        private String serialNumber;

        private String name;

        private String giveTo;

        private String contact;

        private String business;

        public enum Priority {
            low, normal, high, urgent
        }

        public enum Status {
            moi, dong
        }

        @Enumerated(EnumType.STRING)
        private Ticket.Status status;

        @Enumerated(EnumType.STRING)
        private Ticket.Priority priority;

        private String createdByCode;

        private String assignedToCode;

        private Timestamp createdAt;

        private Timestamp updatedAt;

        private String projectCode;
    }
    @Data
    class Detail {

        private Long id;

        private String serialNumber;

        private String name;

        private String giveTo;

        private String contact;

        private String business;

        private String projectCode;
    }
}
