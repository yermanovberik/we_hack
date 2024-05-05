package com.we_hack.smart_order_managment_system.repositories;

import com.we_hack.smart_order_managment_system.models.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
}
