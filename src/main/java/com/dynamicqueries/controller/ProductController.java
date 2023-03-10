package com.dynamicqueries.controller;

import com.dynamicqueries.dto.ProductDTO;
import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import com.dynamicqueries.service.MongoProductService;
import com.dynamicqueries.service.PostgresProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private PostgresProductService postgresProductService;

    @Autowired
    private MongoProductService mongoProductService;


    @GetMapping("/postgres")
    public ResponseEntity<List<ProductDTO>> postgresFind( String name
                                                        , String description
                                                        , ProductCategory category
                                                        , ProductType type
                                                        , Gender gender
                                                        , ProductSize size
                                                        , ProductColor color
                                                        , ProductBrand brand
                                                        , BigDecimal price ){

        return this.postgresProductService.find(  name
                                                , description
                                                , category
                                                , type
                                                , gender
                                                , size
                                                , color
                                                , brand
                                                , price);
    }

    @GetMapping("/mongo")
    public ResponseEntity<List<ProductDTO>> mongoFind(String name
                                                    , String description
                                                    , ProductCategory category
                                                    , ProductType type
                                                    , Gender gender
                                                    , ProductSize size
                                                    , ProductColor color
                                                    , ProductBrand brand
                                                    , BigDecimal price ){

        return this.mongoProductService.find( name
                                            , description
                                            , category
                                            , type
                                            , gender
                                            , size
                                            , color
                                            , brand
                                            , price);
    }

}
