package com.dynamicqueries.model.nosql;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("product")
public class Product {

    @Id
    private String id;

    private String Name;
    private String description;
    private ProductCategory category;
    private ProductType type;
    private Gender gender;
    private ProductSize size;
    private ProductColor color;
    private ProductBrand brand;
    private BigDecimal price;
}
