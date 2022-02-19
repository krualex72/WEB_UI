package lesson3;

//        2. Задача:
//        Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//        Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        Для хранения фруктов внутри коробки можно использовать ArrayList;
//        Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//        Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
//        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
//        Не забываем про метод добавления фрукта в коробку.

public class HomeWork3 {

    public static void main(String[] args) {
	// System.out.println (Orange.getWeight() + Apple.getWeight());

        Box<Apple> appleBox1 = new Box<>( Apple,25.0f, 5); //Box<Apple> appleBox1 = new Box<Apple>(Apple,25.0f, 5);
        // Box<Orange> box2 = new Box<Orange>( Orange,20.0f, 1);
        System.out.println (appleBox1.getWeightLimit());
        System.out.println (appleBox1.getCounts());
        System.out.println (appleBox1.getContent());
        // SwapArrayData.ArrayData<Float> arrayFloat = new SwapArrayData.ArrayData<Float>(1.0f, 8.0f);

        }
}

