package lesson3;

public class Box <T extends Fruit>{
    private T content; // тип фрукта
    private float weightLimit; // вместимость (по весу)
    private int counts; // число фруктов в коробке

    public Box(T content, float weightLimit, int counts) {
        this.content = content;
        this.weightLimit = weightLimit;
        this.counts = counts;
    }

    public T getContent() {
        return content;
    }

    public float getWeightLimit() {
        return weightLimit;
    }

    public int getCounts() {
        return counts;
    }

    public float getWeight() {
        float weight = counts*content.getWeight();
        return weight;
    }
}
