package sample.cafekiosk.spring.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    /**
     * select *
     * from product
     * where selling_type in ('SELLING', 'TEMPORARY')
     */
    List<Product> findAllBySellingStatusIn(List<ProductSellingStatus> sellingType);

    List<Product> findAllByProductNumberIn(List<String> productNumbers);

    @Query("select p.productNumber from Product p order by p.id desc limit 1")
    String findLatestProduct();
}
