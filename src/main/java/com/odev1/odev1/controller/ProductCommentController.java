package com.odev1.odev1.controller;

import com.odev1.odev1.converter.ProductCommentMapper;
import com.odev1.odev1.dto.ProductCommentSave;
import com.odev1.odev1.dto.ProductCommentSaveResponse;
import com.odev1.odev1.entity.Product;
import com.odev1.odev1.entity.ProductComment;
import com.odev1.odev1.entity.User;
import com.odev1.odev1.repository.ProductCommentRepository;
import com.odev1.odev1.repository.ProductRepository;
import com.odev1.odev1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-comments")
@RequiredArgsConstructor
public class ProductCommentController {
    private final ProductCommentRepository productCommentRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    @PostMapping
    public ProductCommentSaveResponse save(@RequestBody ProductCommentSave productCommentSave){
        User user=userRepository.findById(productCommentSave.getUserId()).orElse(null);
        Product product=productRepository.findById(productCommentSave.getProductId()).orElse(null);
        ProductComment productComment=ProductCommentMapper.INSTANCE.map(productCommentSave);
        productComment.setUser(user);
        productComment.setProduct(product);
        productCommentRepository.save(productComment);
        return ProductCommentMapper.INSTANCE.map(productComment);
    }
}
