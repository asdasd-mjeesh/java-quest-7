package domain.store;

import data.util.BinaryFileExecutor;
import domain.store.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;

public final class Store extends ProductStorage {
    private Catalog catalog;

    public Store() {
        super(BinaryFileExecutor.readFile());
        catalog = new Catalog(super.getProducts());
        initProductId();
    }

    public void addProduct(String name, String producer, int cost, LocalDate shelfLife, int count) {
        super.getProducts().add(new Product(name, producer, cost, shelfLife, count));
        catalog.update();
        save();
    }

    public void deleteProduct(int id) {
        super.getProducts().removeIf(s -> s.getId() == id);
        BinaryFileExecutor.deleteProduct(id);
        catalog.update();
    }

    private void save() {
        BinaryFileExecutor.saveProductsToFile(super.getProducts());
    }

    private void initProductId() {
        try {
            Product.setCountOfProducts(
                    super.getProducts().stream().max(
                            Comparator.comparing(Product::getId)).get().getId());
        } catch (NoSuchElementException ignored) {
            // ignored
        }
    }

    public Map<String, ArrayList<Product>> getProducers() {
        return catalog.getProducers();
    }
}
