package com.dynamicqueries.model.sql;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductType;
import com.dynamicqueries.model.enums.ProductSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "sequence_product" , sequenceName = "SEQ_PRODUCT", initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_product")
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private ProductCategory category;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private ProductSize size;

    @Enumerated(EnumType.STRING)
    private ProductColor color;

    @Enumerated(EnumType.STRING)
    private ProductBrand brand;

    private BigDecimal price;

}
