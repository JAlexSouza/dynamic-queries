package com.dynamicqueries.repository;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import com.dynamicqueries.model.sql.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class PostegresProductCustomRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Product> customQuery( String name
                                    , String description
                                    , ProductCategory category
                                    , ProductType type
                                    , Gender gender
                                    , ProductSize size
                                    , ProductColor color
                                    , ProductBrand brand
                                    , BigDecimal price ){

        String query = " Select * from product ";
        String condition = " where 1 = 1 ";

        if(name != null){
            condition += " and name = '" + name + "' ";
        }

        if(description != null){
            condition += " and description = '" + description + "' ";
        }

        if(category != null){
            condition += " and category = '" + category + "' ";
        }

        if(type != null){
            condition += " and type = '" + type + "' ";
        }

        if(gender != null){
            condition += " and gender = '" + gender + "' ";
        }

        if(size != null){
            condition += " and size = '" + size + "' ";
        }

        if(color != null){
            condition += " and color = '" + color + "' ";
        }

        if(brand != null){
            condition += " and brand = '" + brand + "' ";
        }

        if(price != null){
            condition += " and price <= " + price;
        }

        String customQuery = query + condition;
        var result = this.entityManager.createNativeQuery(customQuery, Product.class);

        return result.getResultList();
    }

}
