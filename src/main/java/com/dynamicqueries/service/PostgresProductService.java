package com.dynamicqueries.service;

import com.dynamicqueries.dto.ProductDTO;
import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import com.dynamicqueries.model.sql.Product;
import com.dynamicqueries.repository.PostegresProductCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PostgresProductService {

    @Autowired
    private PostegresProductCustomRepository postegresProductCustomRepository;

    public ResponseEntity<List<ProductDTO>> find( String name
                                                , String description
                                                , ProductCategory category
                                                , ProductType type
                                                , Gender gender
                                                , ProductSize size
                                                , ProductColor color
                                                , ProductBrand brand
                                                , BigDecimal price ){

        List<Product> products = this.postegresProductCustomRepository.customQuery(name
                                                                                , description
                                                                                , category
                                                                                , type
                                                                                , gender
                                                                                , size
                                                                                , color
                                                                                , brand
                                                                                , price);

        if ( products == null || products.isEmpty() ){
            return new ResponseEntity<List<ProductDTO>>(Collections.emptyList(), HttpStatus.OK);
        }

        List<ProductDTO> productsDTO = converter(products);

        return new ResponseEntity<List<ProductDTO>>(productsDTO, HttpStatus.OK);
    }

    public ResponseEntity<List<ProductDTO>> findProductsMongo(String name
                                                            , String description
                                                            , ProductCategory category
                                                            , ProductType type
                                                            , Gender gender
                                                            , ProductSize size
                                                            , ProductColor color
                                                            , ProductBrand brand
                                                            , BigDecimal price ){

        List<Product> products = this.postegresProductCustomRepository.customQuery(name
                , description
                , category
                , type
                , gender
                , size
                , color
                , brand
                , price);

        if ( products == null || products.isEmpty() ){
            return new ResponseEntity<List<ProductDTO>>(Collections.emptyList(), HttpStatus.OK);
        }

        List<ProductDTO> productsDTO = converter(products);

        return new ResponseEntity<List<ProductDTO>>(productsDTO, HttpStatus.OK);
    }

    private List<ProductDTO> converter(List<Product> products) {
        List<ProductDTO> productsDTO = new ArrayList<ProductDTO>();
        for (Product product : products) {
            productsDTO.add(ProductDTO.builder()
                                        .name(product.getName())
                                        .description(product.getDescription())
                                        .category(product.getCategory())
                                        .type(product.getType())
                                        .gender(product.getGender())
                                        .size(product.getSize())
                                        .color(product.getColor())
                                        .brand(product.getBrand())
                                        .price(product.getPrice())
                                        .build());
        }

        return productsDTO;
    }
}
