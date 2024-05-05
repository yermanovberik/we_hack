package com.we_hack.smart_order_managment_system.dto.user;


import lombok.Builder;

import java.util.Date;

@Builder
public record UserAllInfo(

        String fullName,
        String avatarPath,
        String IIN,

        Date birthDate,

        String sex,

         String region,

        String city,

       String address


) {
}
