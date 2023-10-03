package com.odev1.odev1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "product_coments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 500)
    private String comment;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
}
