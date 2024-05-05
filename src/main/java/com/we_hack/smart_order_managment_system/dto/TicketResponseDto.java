package com.we_hack.smart_order_managment_system.dto;

import com.we_hack.smart_order_managment_system.enums.Status;
import com.we_hack.smart_order_managment_system.models.Queue;
import com.we_hack.smart_order_managment_system.models.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Builder;

@Builder
public record TicketResponseDto(
       Long id,

       Long ticketNumber,

       Status status,
       String priority

) {
}
