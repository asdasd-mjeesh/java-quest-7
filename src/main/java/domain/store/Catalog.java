package domain.store;

import domain.store.product.Product;

import java.util.*;

public final class Catalog extends ProductStorage {
    private Map<String, ArrayList<Product>> producers;

    public Catalog(List<Product> products) {
        super(products);
        producers = new HashMap<>();
        searchProducers();
    }

    public void update() {
        searchProducers();
    }

    private void searchProducers() {
        var products = super.getProducts();

        producers.clear();
        for (Product product : products) {
            producers.put(product.getProducer(), searchProducts(product.getProducer()));
        }
    }

    private ArrayList<Product> searchProducts(String producerName) {
        List<Product> allProducts = super.getProducts();
        ArrayList<Product> filterProducts = new ArrayList<>();

        for (Product product : allProducts) {
            if (product.getProducer().equals(producerName)) {
                filterProducts.add(product);
            }
        }

        return filterProducts;
    }

    public  Map<String, ArrayList<Product>> getProducers() {
        return producers;
    }
}
