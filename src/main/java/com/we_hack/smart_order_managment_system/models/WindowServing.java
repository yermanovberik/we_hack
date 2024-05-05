package com.we_hack.smart_order_managment_system.models;

import com.we_hack.smart_order_managment_system.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "window_serving")
public class WindowServing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Ticket currentTicket;

    @ManyToOne
    private Window window;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

}
