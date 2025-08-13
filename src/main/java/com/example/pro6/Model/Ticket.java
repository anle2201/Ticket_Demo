package com.example.pro6.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "serial_number")
    private String serialNumber;

    @Column(nullable = false, name = "ticket_name")
    private String name;

    @Column(nullable = false, name = "give_to")
    private String giveTo;

    @Column(nullable = false, name = "contact")
    private String contact;

    @Column(nullable = true, name = "business")
    private String business;

    public enum Priority {
        low, normal, high, urgent
    }

    public enum Status {
        moi, dong
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Column(nullable = true, name = "SLA_status")
    private String createdByCode;

    @Column(nullable = true, name = "SLA_target")
    private String assignedToCode;

    @Column(nullable = true, name = "created_at")
    private Timestamp createdAt;

    @Column(nullable = true, name = "updated_at")
    private Timestamp updatedAt;

    @Column(nullable = true, name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(nullable = true, name = "is_reception")
    private Boolean isReception = false;

}




