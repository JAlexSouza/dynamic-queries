package com.dynamicqueries.dto;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
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
}
