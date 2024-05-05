package com.we_hack.smart_order_managment_system.services.impl;


import com.we_hack.smart_order_managment_system.models.Queue;
import com.we_hack.smart_order_managment_system.repositories.QueueRepository;
import com.we_hack.smart_order_managment_system.repositories.UserRepository;
import com.we_hack.smart_order_managment_system.repositories.WindowServingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WindowServingService {
    private final WindowServingRepository windowServingRepository;
    private final QueueRepository queueRepository;
    private final UserRepository userRepository;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    public synchronized void next(Long managerId){
        List<Queue> queue = queueRepository.findAll();

    }

}
