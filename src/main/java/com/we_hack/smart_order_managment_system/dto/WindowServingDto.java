package com.we_hack.smart_order_managment_system.dto;

import com.we_hack.smart_order_managment_system.enums.Status;
import com.we_hack.smart_order_managment_system.models.Ticket;
import com.we_hack.smart_order_managment_system.models.Window;
import jakarta.persistence.*;
import lombok.Builder;

@Builder
public record WindowServingDto(


        Long id,

        String currentTicket,

        Long windowId,

        String status

) {
}
