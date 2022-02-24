package domain.store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class ProductFilter {
    private final List<Product> products;

    public ProductFilter(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    // a
    public List<Product> getAllSortedByShelfLifeWithName(String name) {
        List<Product> result = new ArrayList<>(getAllWithName(name));
        result.retainAll(getAllSortedByShelfLife());
        result.sort(Comparator.comparing(Product::getShelfLife));

        return result;
    }

    // supported method for a
    public List<Product> getAllSortedByShelfLife() {
        List<Product> result = new ArrayList<>(products);
        result.sort(Comparator.comparing(Product::getShelfLife));

        return result;
    }

    // supported method for a and b
    public List<Product> getAllWithName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product item : products) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }

        return result;
    }

    // b
    public List<Product> getProductsWithNameAndCostALess(String name, int maxCost) {
        var result = getAllWithName(name);
        result.retainAll(getAllWithPriceALess(maxCost));

        return result;
    }

    // supported method for b
    public List<Product> getAllWithPriceALess(int maxCost) {
        List<Product> result = new ArrayList<>();
        for (Product item : products) {
            if (item.getCost() <= maxCost) {
                result.add(item);
            }
        }

        return result;
    }

    // c
    public List<Product> getAllWithShelfLifeALong(LocalDate minShelfLife) {
        List<Product> result = new ArrayList<>();
        for (Product item : products) {
            if (item.getShelfLife().isAfter(minShelfLife)) {
                result.add(item);
            }
        }

        return result;
    }

    // d
    public List<Product> getAllSortedByPrice() {
        List<Product> result = new ArrayList<>(products);
        result.sort(new PriceComparator());

        return result;
    }

    // comparator for d
    private static class PriceComparator implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            // == return 0
            // > return 1
            // < return - 1
            int price1 = o1.getPrice();
            int price2 = o2.getPrice();
            if (price1 > price2) {
                return 1;
            } else if (price1 < price2) {
                return -1;
            }

            int cost1 = o1.getCost();
            int cost2 = o2.getCost();
            if (cost1 > cost2) {
                return 1;
            } else if (cost1 < cost2) {
                return -1;
            }
            return 0;
        }
    }
}
