package com.dynamicqueries;

import com.dynamicqueries.model.enums.Gender;
import com.dynamicqueries.model.enums.ProductBrand;
import com.dynamicqueries.model.enums.ProductCategory;
import com.dynamicqueries.model.enums.ProductColor;
import com.dynamicqueries.model.enums.ProductSize;
import com.dynamicqueries.model.enums.ProductType;
import com.dynamicqueries.model.sql.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class PostegresSeederRunner implements CommandLineRunner {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        clean();
        seed();
    }

    private void clean() {
        this.entityManager.createNativeQuery(" delete from product ").executeUpdate();
    }

    private void seed() {

        List<Product> products = new ArrayList<Product>();

        products.add(Product.builder()
                .name("booster A37")
                .description("Extra shocker absorber")
                .category(ProductCategory.SHOES)
                .type(ProductType.SPORTING)
                .gender(Gender.FEMALE)
                .size(ProductSize.S)
                .color(ProductColor.BLUE)
                .brand(ProductBrand.ADIDAS)
                .price(new BigDecimal("200.0"))
                .build());

        products.add(Product.builder()
                .name("Extreme dry")
                .description("Sweat protection")
                .category(ProductCategory.CLOTHES)
                .type(ProductType.SPORTING)
                .gender(Gender.MALE)
                .size(ProductSize.M)
                .color(ProductColor.WHITE)
                .brand(ProductBrand.NIKE)
                .price(new BigDecimal("150.0"))
                .build());

        products.add(Product.builder()
                .name("Casual F96")
                .description("Casual shirt")
                .category(ProductCategory.CLOTHES)
                .type(ProductType.CASUAL)
                .gender(Gender.MALE)
                .size(ProductSize.B)
                .color(ProductColor.BLACK)
                .brand(ProductBrand.ADIDAS)
                .price(new BigDecimal("180.0"))
                .build());

        products.add(Product.builder()
                .name("Her feeling")
                .description("furry hooded sweatshirt")
                .category(ProductCategory.CLOTHES)
                .type(ProductType.CASUAL)
                .gender(Gender.FEMALE)
                .size(ProductSize.S)
                .color(ProductColor.BLUE)
                .brand(ProductBrand.PRADA)
                .price(new BigDecimal("500.0"))
                .build());

        products.add(Product.builder()
                .name("Chelsea")
                .description("Leather boot")
                .category(ProductCategory.SHOES)
                .type(ProductType.DRESS)
                .gender(Gender.MALE)
                .size(ProductSize.M)
                .color(ProductColor.BLACK)
                .brand(ProductBrand.PRADA)
                .price(new BigDecimal("600.0"))
                .build());

        products.add(Product.builder()
                .name("Monk Strap")
                .description("Leather shoes")
                .category(ProductCategory.SHOES)
                .type(ProductType.DRESS)
                .gender(Gender.MALE)
                .size(ProductSize.M)
                .color(ProductColor.BLACK)
                .brand(ProductBrand.PRADA)
                .price(new BigDecimal("750.0"))
                .build());

        products.add(Product.builder()
                .name("Sparkling Five7")
                .description("Shine dress")
                .category(ProductCategory.CLOTHES)
                .type(ProductType.DRESS)
                .gender(Gender.FEMALE)
                .size(ProductSize.M)
                .color(ProductColor.WHITE)
                .brand(ProductBrand.PRADA)
                .price(new BigDecimal("930.0"))
                .build());

        products.add(Product.builder()
                .name("2000 energy")
                .description("Sunglasses of new era")
                .category(ProductCategory.ACCESSORIES)
                .type(ProductType.CASUAL)
                .gender(Gender.FEMALE)
                .size(ProductSize.S)
                .color(ProductColor.BLUE)
                .brand(ProductBrand.NIKE)
                .price(new BigDecimal("90.0"))
                .build());

        products.add(Product.builder()
                .name("2000 energy")
                .description("Sunglasses of new era")
                .category(ProductCategory.ACCESSORIES)
                .type(ProductType.CASUAL)
                .gender(Gender.MALE)
                .size(ProductSize.M)
                .color(ProductColor.BLACK)
                .brand(ProductBrand.NIKE)
                .price(new BigDecimal("80.0"))
                .build());

        products.add(Product.builder()
                .name("Modern Man")
                .description("Leather wallet")
                .category(ProductCategory.ACCESSORIES)
                .type(ProductType.CASUAL)
                .gender(Gender.MALE)
                .size(ProductSize.S)
                .color(ProductColor.BLACK)
                .brand(ProductBrand.PRADA)
                .price(new BigDecimal("250.0"))
                .build());

        products.add(Product.builder()
                .name("Modern Man")
                .description("Leather wallet")
                .category(ProductCategory.ACCESSORIES)
                .type(ProductType.CASUAL)
                .gender(Gender.MALE)
                .size(ProductSize.S)
                .color(ProductColor.BLACK)
                .brand(ProductBrand.PRADA)
                .price(new BigDecimal("290.0"))
                .build());

        products.add(Product.builder()
                .name("Adidas metal&fire")
                .description("Silver necklace")
                .category(ProductCategory.ACCESSORIES)
                .type(ProductType.CASUAL)
                .gender(Gender.FEMALE)
                .size(ProductSize.S)
                .color(ProductColor.BLUE)
                .brand(ProductBrand.ADIDAS)
                .price(new BigDecimal("400.0"))
                .build());

        products.add(Product.builder()
                .name("Adidas metal&fire")
                .description("Silver necklace")
                .category(ProductCategory.ACCESSORIES)
                .type(ProductType.CASUAL)
                .gender(Gender.FEMALE)
                .size(ProductSize.S)
                .color(ProductColor.WHITE)
                .brand(ProductBrand.ADIDAS)
                .price(new BigDecimal("420.0"))
                .build());

        products.add(Product.builder()
                .name("Jungle")
                .description("Leather bracelets")
                .category(ProductCategory.ACCESSORIES)
                .type(ProductType.CASUAL)
                .gender(Gender.MALE)
                .size(ProductSize.B)
                .color(ProductColor.BLACK)
                .brand(ProductBrand.NIKE)
                .price(new BigDecimal("70.0"))
                .build());

        products.add(Product.builder()
                .name("Jungle")
                .description("Leather bracelets")
                .category(ProductCategory.ACCESSORIES)
                .type(ProductType.CASUAL)
                .gender(Gender.FEMALE)
                .size(ProductSize.B)
                .color(ProductColor.BLACK)
                .brand(ProductBrand.NIKE)
                .price(new BigDecimal("70.0"))
                .build());

        for (Product product : products ) {
            this.entityManager.persist(product);
        }
    }
}
