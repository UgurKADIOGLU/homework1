package com.odev1.odev1.converter;

import com.odev1.odev1.dto.ProductCommentSave;
import com.odev1.odev1.dto.ProductCommentSaveResponse;
import com.odev1.odev1.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentMapper {
    ProductCommentMapper INSTANCE = Mappers.getMapper(ProductCommentMapper.class);
    @Mapping(target = "user.id",source = "userId")
    @Mapping(target = "product.id",source = "productId")
    ProductComment map(ProductCommentSave productCommentSave);
    @Mapping(target = "userName",source = "user.name")
    @Mapping(target = "productName",source = "product.name")
    ProductCommentSaveResponse map(ProductComment productComment);
}
