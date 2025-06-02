package sample.cafekiosk.spring.api.controller.product.dto.request;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductSellingStatus;
import sample.cafekiosk.spring.domain.product.ProductType;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class ProductCreateRequest {

    @NotNull(message = "상품 타입은 필수입니다.")
    private ProductType type;
    @NotNull(message = "상품 판매상태는 필수입니다.")
    private ProductSellingStatus sellingStatus;
    @Positive(message = "상품 가격은 양수여야 합니다.")
    private int price;
    @NotBlank(message = "상품 이름은 필수입니다.")
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
