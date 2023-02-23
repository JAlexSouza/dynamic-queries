package com.dynamicqueries.model.nosql;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("product")
public class Product {

    @Id
    private String id;

    private ProductCategory category;
    private ProductType type;
    private Gender gender;
    private ProductSize size;
    private ProductColor color;
    private ProductBrand brand;
    private BigDecimal price;
}
