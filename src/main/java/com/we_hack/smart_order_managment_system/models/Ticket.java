package com.we_hack.smart_order_managment_system.models;

import com.we_hack.smart_order_managment_system.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Statement;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket_")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticketNumber")
    private String ticketNumber;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "priority")
    private String priority;

    @ManyToOne
    private User user;

    @OneToOne
    private Queue queues;

}
