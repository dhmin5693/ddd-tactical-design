package kitchenpos.products.tobe.ui;

import kitchenpos.products.tobe.domain.TobeProduct;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductForm {
    private UUID id;
    private String name;
    private BigDecimal price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static ProductForm of(TobeProduct tobeProduct) {
        final ProductForm productForm = new ProductForm();
        productForm.setId(tobeProduct.getId());
        productForm.setName(tobeProduct.getName());
        productForm.setPrice(tobeProduct.getPrice());
        return productForm;
    }
}