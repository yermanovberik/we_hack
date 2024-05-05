package com.we_hack.smart_order_managment_system.dto.user;

import java.util.Date;

public record UserFullInfoDto(

        String IIN,

        Date birthDate,

        String sex,

        String region,

        String city,
         String address
) {
}
