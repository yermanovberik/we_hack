package com.we_hack.smart_order_managment_system.models;

import com.we_hack.smart_order_managment_system.repositories.TicketRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "queue")
public class  Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Ticket ticket;

    @Column(name = "date_time")
    private LocalDateTime dateTime;


}
