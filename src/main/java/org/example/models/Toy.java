package org.example.models;

public class Toy {
    private final int id;
    private String name;
    private int weight;

    public static int count;

    public Toy(String name, int weight) {
        id = ++count;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("id: %2d Имя: %-20s Вероятность выпадения: %d%%", id, name, weight);
    }
}
