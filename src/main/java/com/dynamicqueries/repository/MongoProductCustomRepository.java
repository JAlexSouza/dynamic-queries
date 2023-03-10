package com.dynamicqueries.repository;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import com.dynamicqueries.model.nosql.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class MongoProductCustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> customQuery( String name
                                    , String description
                                    , ProductCategory category
                                    , ProductType type
                                    , Gender gender
                                    , ProductSize size
                                    , ProductColor color
                                    , ProductBrand brand
                                    , BigDecimal price ){

        Query query = new Query();

        if(name != null){
            Criteria nameCriteria = Criteria.where("name").is(name);
            query.addCriteria(nameCriteria);
        }

        if(description != null){
            Criteria descriptionCriteria = Criteria.where("description").is(description);
            query.addCriteria(descriptionCriteria);
        }

        if(category != null){
            Criteria categoryCriteria = Criteria.where("category").is(category);
            query.addCriteria(categoryCriteria);
        }

        if(type != null){
            Criteria typeCriteria = Criteria.where("type").is(type);
            query.addCriteria(typeCriteria);
        }

        if(gender != null){
            Criteria genderCriteria = Criteria.where("gender").is(gender);
            query.addCriteria(genderCriteria);
        }

        if(size != null){
            Criteria sizeCriteria = Criteria.where("size").is(size);
            query.addCriteria(sizeCriteria);
        }

        if(color != null){
            Criteria colorCriteria = Criteria.where("color").is(color);
            query.addCriteria(colorCriteria);
        }

        if(brand != null){
            Criteria brandCriteria = Criteria.where("brand").is(brand);
            query.addCriteria(brandCriteria);
        }

        if(price != null){
            Criteria priceCriteria = Criteria.where("price").lte(price);
            query.addCriteria(priceCriteria);
        }

        return mongoTemplate.find(query, Product.class);
    }

}
