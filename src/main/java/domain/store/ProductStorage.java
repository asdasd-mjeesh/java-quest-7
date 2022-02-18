package domain.store;

import domain.store.product.Product;

import java.util.List;

public abstract class ProductStorage {
    private List<Product> products;

    public ProductStorage(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
