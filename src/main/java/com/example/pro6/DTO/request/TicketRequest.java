package com.example.pro6.DTO.request;

import com.example.pro6.Model.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


import java.sql.Timestamp;

public interface TicketRequest {
@Data
class CreatTicket{

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

    private Boolean isDeleted = false ;

    private Boolean isReception = false;

    }
@Data
    class UpdateReception{
    private Long id;
    private Boolean isReception;

}
}


