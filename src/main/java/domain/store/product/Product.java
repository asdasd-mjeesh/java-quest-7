package domain.store.product;

import domain.store.product.interfaces.HavingAnShelfLife;
import domain.store.product.interfaces.Named;
import domain.store.product.interfaces.Pricey;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Named, Pricey, HavingAnShelfLife, Serializable {
    private static final long serialVersionUID = 1337;
    private static int countProducts = 0;
    private final int id;
    private String name;
    private String producer;
    private int cost;
    private LocalDate shelfLife;
    private int count;
    private int price;

    public Product(String name, String producer, int cost, LocalDate shelfLife, int count) {
        countProducts++;
        this.id = countProducts;
        this.name = name;
        this.producer = producer;
        this.cost = cost;
        this.shelfLife = shelfLife;
        this.count = count;
        this.price = cost * count;
    }

    @Override
    public String toString() {
        return new String
                ("id: " + id + "\n" +
                        "name: " + name + "\n" +
                        "producer: " + producer + "\n" +
                        "cost: " + cost + "\n" +
                        "shelf life: " + shelfLife + "\n" +
                        "count: " + count + "\n"
                );
    }

    public static void setCountOfProducts(int count) {
        countProducts = count;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public LocalDate getShelfLife() {
        return shelfLife;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
