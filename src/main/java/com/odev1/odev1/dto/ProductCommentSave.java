package com.odev1.odev1.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ProductCommentSave {
    private String comment;
    private LocalDate date;
    private Long userId;
    private Long productId;
}
