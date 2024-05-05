package com.we_hack.smart_order_managment_system.services.impl;

import com.we_hack.smart_order_managment_system.dto.TicketResponseDto;
import com.we_hack.smart_order_managment_system.dto.WindowServingDto;
import com.we_hack.smart_order_managment_system.dto.entity.EntityNotFoundException;
import com.we_hack.smart_order_managment_system.enums.Status;
import com.we_hack.smart_order_managment_system.models.Queue;
import com.we_hack.smart_order_managment_system.models.Ticket;
import com.we_hack.smart_order_managment_system.models.User;
import com.we_hack.smart_order_managment_system.models.WindowServing;
import com.we_hack.smart_order_managment_system.repositories.QueueRepository;
import com.we_hack.smart_order_managment_system.repositories.TicketRepository;
import com.we_hack.smart_order_managment_system.repositories.UserRepository;
import com.we_hack.smart_order_managment_system.repositories.WindowServingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service

public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final WindowServingRepository windowServingRepository;
    private final QueueRepository queueRepository;
    private static long countOfTicket = 1;

    public TicketResponseDto generateTicket(String IIN){
        User user = userRepository.findByIIN(IIN)
                .orElseThrow(() -> new EntityNotFoundException("User with this " + IIN + " not found!"));

        List<Ticket> ticketList = user.getTickets();

        for(Ticket ticket : ticketList){
            if(ticket.getStatus()){
                throw new RuntimeException("You have already ticket");
            }
        }

        Ticket ticket = Ticket.builder()
                .ticketNumber(countOfTicket+"")
                .status(true)
                .priority("OFFLINE")
                .user(user)
                .build();
        long currentCountOfTicket = countOfTicket;
        countOfTicket++;

        Queue queue = Queue.builder()
                .ticket(ticket)
                .dateTime(LocalDateTime.now())
                .build();

        queueRepository.save(queue);



        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .ticketNumber(currentCountOfTicket)
                .status(Status.CONFIRMED)
                .priority("OFFLINE")
                .build();
        return ticketResponseDto;
    }

    public List<WindowServingDto> getAllWindowServing(){
        List<WindowServingDto> windowServingDtos = new ArrayList<>();

        List<WindowServing> windowServings = windowServingRepository.findAll();

        for(WindowServing windowServing : windowServings){
            WindowServingDto windowServingDto  = WindowServingDto.builder()
                    .currentTicket(windowServing.getCurrentTicket().getTicketNumber())
                    .windowId(windowServing.getWindow().getId())
                    .status(windowServing.getStatus().name())
                    .build();

            windowServingDtos.add(windowServingDto);
        }
        return windowServingDtos;
    }

}
