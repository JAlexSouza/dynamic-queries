package com.dynamicqueries.service;

import com.dynamicqueries.dto.ProductDTO;
import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import com.dynamicqueries.model.sql.Product;
import com.dynamicqueries.repository.PostgresProductCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostgresProductService {

    @Autowired
    private PostgresProductCustomRepository postgresProductCustomRepository;

    public ResponseEntity<List<ProductDTO>> find( String name
                                                , String description
                                                , ProductCategory category
                                                , ProductType type
                                                , Gender gender
                                                , ProductSize size
                                                , ProductColor color
                                                , ProductBrand brand
                                                , BigDecimal price ){

        List<Product> products = this.postgresProductCustomRepository.customQuery(name
                                                                                , description
                                                                                , category
                                                                                , type
                                                                                , gender
                                                                                , size
                                                                                , color
                                                                                , brand
                                                                                , price);

        if ( products == null || products.isEmpty() ){
            return new ResponseEntity<List<ProductDTO>>(HttpStatus.NO_CONTENT);
        }

        List<ProductDTO> productsDTO = products.stream().map(ProductDTO::convert).collect(Collectors.toList());

        return new ResponseEntity<List<ProductDTO>>(productsDTO, HttpStatus.OK);
    }

}
