package com.odev1.odev1.repository;
import com.odev1.odev1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("from Product p where p.expirationDate > ?1 or p.expirationDate is null")
    //@Query("from Product p where p.expirationDate > :date or p.expirationDate is null")
    List<Product> findAllExpiredOrExpirationDateNull(LocalDate date);
    @Query("from Product p where p.expirationDate < ?1")
    List<Product> findAllByExpiredDate(LocalDate date);
}
