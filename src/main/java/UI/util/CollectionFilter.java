package UI.util;

import domain.store.product.interfaces.Costly;
import domain.store.product.interfaces.HavingAnShelfLife;
import domain.store.product.interfaces.Named;
import domain.store.product.interfaces.Pricey;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class CollectionFilter {

    private CollectionFilter() {  }

    public static<T extends Named> ArrayList<T> getAllWithName(String name, List<T> initial) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : initial) {
            if (item.getName().equals(name)) {
                result.add(item);
            }
        }

        return result;
    }

    public static<T extends Costly> ArrayList<T> getAllWithPriceALess(int maxCost, List<T> initial) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : initial) {
            if (item.getCost() <= maxCost) {
                result.add(item);
            }
        }

        return result;
    }

    public static<T extends HavingAnShelfLife> ArrayList<T> getAllWithShelfLifeALong(LocalDate minShelfLife, List<T> initial) {
        ArrayList<T> result = new ArrayList<>();
        for (T item : initial) {
            if (item.getShelfLife().isAfter(minShelfLife)) {
                result.add(item);
            }
        }

        return result;
    }

    public static<T extends Pricey> ArrayList<T> getAllSortedByPrice(List<T> initial) {
        ArrayList<T> result = new ArrayList<>(initial);
        result.sort(Comparator.comparing(T::getPrice));

        return result;
    }

    public static<T extends HavingAnShelfLife> ArrayList<T> getAllSortedByShelfLife(List<T> initial) {
        ArrayList<T> result = new ArrayList<>(initial);
        result.sort(Comparator.comparing(T::getShelfLife));

        return result;
    }
}
