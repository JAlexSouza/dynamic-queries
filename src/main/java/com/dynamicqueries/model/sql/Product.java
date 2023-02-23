package com.dynamicqueries.model.sql;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductType;
import com.dynamicqueries.model.enums.ProductSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    @SequenceGenerator(name = "sequence_product" , sequenceName = "SEQ_PRODUCT", initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_product")
    private Long id;

    private ProductCategory category;
    private ProductType type;
    private Gender gender;
    private ProductSize size;
    private ProductColor color;
    private ProductBrand brand;
    private BigDecimal price;

}
