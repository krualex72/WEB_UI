package lesson3;

public class Box <T extends Fruit>{
    private T content; // тип фрукта
    private float weightLimit; // вместимость (по весу)
    private int counts; // число фруктов в коробке

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public float getWeight() {
        return 1.5f;
    }

}
