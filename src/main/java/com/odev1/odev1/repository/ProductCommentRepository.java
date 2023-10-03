package com.odev1.odev1.repository;
import com.odev1.odev1.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ProductCommentRepository extends JpaRepository<ProductComment,Long> {
    List<ProductComment> findAllByProduct_Id(Long productId);
    List<ProductComment> findAllByUser_Id(Long userId);
    List<ProductComment> findAllByProduct_IdAndDateBetween(Long productId, LocalDate start,LocalDate end);
    List<ProductComment> findAllByUser_IdAndDateBetween(Long userId, LocalDate start,LocalDate end);
}
