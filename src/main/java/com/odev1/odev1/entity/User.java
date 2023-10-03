package com.odev1.odev1.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String name;
    @Column(nullable = false,length = 50)
    private String surName;
    @Column(nullable = false,length = 50)
    private String email;
    @Column(length = 15)
    private String phoneNumber;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ProductComment> productComment;
}
