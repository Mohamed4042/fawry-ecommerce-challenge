package fawry.services;

import java.util.*;
import fawry.interfaces.Shippable;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        Map<String, Integer> countMap = new LinkedHashMap<>();
        Map<String, Double> weightMap = new LinkedHashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            countMap.put(item.getName(), countMap.getOrDefault(item.getName(), 0) + 1);
            weightMap.put(item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : countMap.keySet()) {
            System.out.printf("%dx %-12s %.0fg\n", countMap.get(name), name, weightMap.get(name));
        }
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight / 1000.0);
    }
}
