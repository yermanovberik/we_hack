package com.we_hack.smart_order_managment_system.dto.user;

import lombok.Builder;

@Builder
public record UserUploadPhotoDto(
        long id,
        String photoUrl
) {
}
