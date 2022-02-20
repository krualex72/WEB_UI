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
        // получение типа фруктов
        return content;
    }

    public float getWeightLimit() {
        // получение максимального объема коробки
        return weightLimit;
    }

    public int getCounts() {
        // определение числа фруктов в коробке
        return counts;
    }

    public float getBoxWeight() {
        // определение веса коробки с фруктами
        float boxWeight = counts*content.getWeight();
        return boxWeight;
    }

    public void addFruits (int num) throws MyBoxOverflowException {
        // добавление фруктов в коробку с проверкой вместимости (по умолчанию фрукт аналогичный)
        float maxFruitsInTheBox = weightLimit / content.getWeight();
        if (maxFruitsInTheBox < counts + num) throw new MyBoxOverflowException ("Данное количество не поместится в " +
                "эту коробку - возьмите другую");
        this.counts += num;
    }

    public boolean compareBoxes (Box box) {
        // сравнение двух коробок
        return (getBoxWeight() == box.getBoxWeight()) ? true : false;
    }
    public void emptyBoxToBox (Box box) throws MyBoxOverflowException {
        // пересыпание фруктов из коробки в текущую коробку с проверкой вместимости
        int removedFruits = box.getCounts(); // кол-во пересыпаемых яблок
        if (content == box.getContent()) { // проаеряем идентичность фруктов
            addFruits(removedFruits); // добавляем фрукты с проверкой вместимости коробки
            box.addFruits(-removedFruits); // опустошаем коробку-донора
        } else {
            System.out.println ("Различные фрукты нельзя смешивать между собой!!!");
        }

    }
}
