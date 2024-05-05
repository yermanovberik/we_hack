package com.we_hack.smart_order_managment_system.controllers;

import com.we_hack.smart_order_managment_system.dto.TicketResponseDto;
import com.we_hack.smart_order_managment_system.models.Ticket;
import com.we_hack.smart_order_managment_system.services.impl.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appoinment")
@RequiredArgsConstructor
public class AppoinmentController {

    private final TicketService ticketService;

    @PostMapping("/create")
    public TicketResponseDto createTicket(@RequestParam String IIN) {
        return ticketService.generateTicket(IIN);
    }
}
