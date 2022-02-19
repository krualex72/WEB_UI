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
        Apple apple = new Apple(); // создаём яблоко
        Orange orange = new Orange(); // создаём апельсин
        Box<Apple> appleBox1 = new Box<Apple>(apple,25.0f, 6); // создаем 1-ю коробку для яблок
        Box<Apple> appleBox2 = new Box<Apple>(apple,30.0f, 4); // создаем 2-ю коробку для яблок
        Box<Apple> appleBox3 = new Box<Apple>(apple,15.0f, 6); // создаем 3-ю коробку для яблок
        Box<Orange> orangeBox1 = new Box<Orange>(orange,20.0f, 4); // создаем 1-ю коробку для апельсинов
        System.out.println ("В коробке 1 сейчас " + appleBox1.getCounts() + " яблок(а). Её вес " + appleBox1.getBoxWeight());
        System.out.println ("В коробке 2 сейчас " + appleBox2.getCounts() + " яблок(а). Её вес " + appleBox2.getBoxWeight());
        System.out.println ("В коробке 3 сейчас " + appleBox3.getCounts() + " яблок(а). Её вес " + appleBox3.getBoxWeight());
        System.out.println ("В коробке 1 сейчас " + orangeBox1.getCounts() + " апельсин(ов). Её вес " + orangeBox1.getBoxWeight());

        System.out.println ("\nКоробка 1 с яблоками равна по весу коробке 1 с апельсинами? - " +
                appleBox1.compareBoxes(orangeBox1)); // сравниваем вес коробок
        System.out.println ("Коробка 1 с яблоками равна по весу коробке 2 с яблоками? - " +
                appleBox1.compareBoxes(appleBox2)); // сравниваем вес коробок
        System.out.println ("Коробка 1 с яблоками равна по весу коробке 3 с яблоками? - " +
                appleBox1.compareBoxes(appleBox3)); // сравниваем вес коробок

        System.out.println ("\nПытаемся добавить в 1-ю коробку 5 яблок");
        try {
            appleBox1.addFruits(5);
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("В коробке 1 стало " + appleBox1.getCounts() + " яблок(а). Её вес " + appleBox1.getBoxWeight());
        System.out.println ("\nПытаемся добавить в 1-ю коробку еще 6 яблок");
        try {
            appleBox1.addFruits(6);
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("В коробке 1 стало " + appleBox1.getCounts() + " яблок(а). Её вес " + appleBox1.getBoxWeight());
        System.out.println ("\nПытаемся добавить в 1-ю коробку еще 15 яблок");
        try {
            appleBox1.addFruits(15);
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("В коробке 1 остлось " + appleBox1.getCounts() + " яблок(а). Её вес " + appleBox1.getBoxWeight());
        System.out.println ("\nПытаемся пересыпать из 2-й коробки яблок в 1-ю коробку яблок");
        try {
            appleBox1.emptyBoxToBox(appleBox2); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 1 стало " + appleBox1.getCounts() + " яблок(а). Её вес " + appleBox1.getBoxWeight());
            System.out.println ("В коробке 2 стало " + appleBox2.getCounts() + " яблок(а). Её вес " + appleBox2.getBoxWeight());
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nПытаемся пересыпать из 3-й коробки яблок в 1-ю коробку яблок");
        try {
            appleBox1.emptyBoxToBox(appleBox3); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 1 стало " + appleBox1.getCounts() + " яблок(а). Её вес " + appleBox1.getBoxWeight());
            System.out.println ("В коробке 3 стало " + appleBox3.getCounts() + " яблок(а). Её вес " + appleBox3.getBoxWeight());
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nПытаемся пересыпать из 3-й коробки яблок во 2-ю коробку яблок");
        try {
            appleBox2.emptyBoxToBox(appleBox3); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 2 стало " + appleBox2.getCounts() + " яблок(а). Её вес " + appleBox2.getBoxWeight());
            System.out.println ("В коробке 3 стало " + appleBox3.getCounts() + " яблок(а). Её вес " + appleBox3.getBoxWeight());
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nПытаемся пересыпать из 1-й коробки апельсин во 2-ю коробку яблок");
        try {
            appleBox2.emptyBoxToBox(orangeBox1); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 2 стало " + appleBox2.getCounts() + " яблок(а). Её вес " + appleBox2.getBoxWeight());
            System.out.println ("В коробке 1 стало " + orangeBox1.getCounts() + " апельсин(ов). Её вес " + orangeBox1.getBoxWeight());
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nПытаемся пересыпать из 2-й коробки яблок во 1-ю коробку апельсинов");
        try {
            orangeBox1.emptyBoxToBox(appleBox2); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 1 стало " + orangeBox1.getCounts() + " апельсин(ов). Её вес " + orangeBox1.getBoxWeight());
            System.out.println ("В коробке 2 стало " + appleBox2.getCounts() + " яблок(а). Её вес " + orangeBox1.getBoxWeight());
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nИТОГОВОЕ СОСТОЯНИЕ КОРОБОК:");
        System.out.println ("В коробке 1 сейчас " + appleBox1.getCounts() + " яблок(а). Её вес " + appleBox1.getBoxWeight());
        System.out.println ("В коробке 2 сейчас " + appleBox2.getCounts() + " яблок(а). Её вес " + appleBox2.getBoxWeight());
        System.out.println ("В коробке 3 сейчас " + appleBox3.getCounts() + " яблок(а). Её вес " + appleBox3.getBoxWeight());
        System.out.println ("В коробке 1 сейчас " + orangeBox1.getCounts() + " апельсин(ов). Её вес " + orangeBox1.getBoxWeight());
        }
}

