package com.odev1.odev1.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,precision = 8,scale = 2)
    private BigDecimal price;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate expirationDate;
    @OneToMany(mappedBy="product")
    @JsonIgnore
    private List<ProductComment> productComment;
}
