package com.we_hack.smart_order_managment_system.repositories;

import com.we_hack.smart_order_managment_system.models.WindowServing;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WindowServingRepository extends JpaRepository<WindowServing, Long> {
}
