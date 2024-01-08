package com.dynamicqueries.dto;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class ProductDTO {

    private String name;
    private String description;
    private ProductCategory category;
    private ProductType type;
    private Gender gender;
    private ProductSize size;
    private ProductColor color;
    private ProductBrand brand;
    private BigDecimal price;

    public static ProductDTO convert(com.dynamicqueries.model.sql.Product product){
        return ProductDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .type(product.getType())
                .gender(product.getGender())
                .size(product.getSize())
                .color(product.getColor())
                .brand(product.getBrand())
                .price(product.getPrice())
                .build();
    }

    public static ProductDTO convert(com.dynamicqueries.model.nosql.Product product){
        return ProductDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .type(product.getType())
                .gender(product.getGender())
                .size(product.getSize())
                .color(product.getColor())
                .brand(product.getBrand())
                .price(product.getPrice())
                .build();
    }
}
