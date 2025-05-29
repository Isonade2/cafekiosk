package sample.cafekiosk.spring.api.controller.product.dto.request;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ProductCreateRequest {
    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private int price;
    private String name;


    @Builder
    public ProductCreateRequest(ProductType type, ProductSellingStatus sellingStatus, int price, String name) {
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.price = price;
        this.name = name;
    }

    public Product toEntity(String nextProductNumber) {
        return Product.builder()
                .productNumber(nextProductNumber)
                .type(type)
                .sellingStatus(sellingStatus)
                .price(price)
                .name(name)
                .build();
    }
}
