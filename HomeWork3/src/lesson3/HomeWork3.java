package lesson3;

public class HomeWork3 {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        // строковый массив
        SwapArrayData.ArrayData<String> arrayString = new SwapArrayData.ArrayData<String>("cat", "dog", "monkey", "donkey", "eagle");
        System.out.print("Original String Array: ");
        arrayString.printArray();
        try {
            arrayString.swapArrayData(1,4);
            System.out.print("Swaped String Array: ");
            arrayString.printArray();
            System.out.println("Swaped Elements: 1 and 4");
        } catch (MyWrongIndexException e) {
            System.out.println(e.getMessage());
        }
        // целочисленный массив
        SwapArrayData.ArrayData<Integer> arrayInteger = new SwapArrayData.ArrayData<Integer>(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.print("\nOriginal Integer Array: ");
        arrayInteger.printArray();
        try {
            arrayInteger.swapArrayData(1,5);
            System.out.print("Swaped Integer Array: ");
            arrayInteger.printArray();
            System.out.println("Swaped Elements: 1 and 5");
        } catch (MyWrongIndexException e) {
            System.out.println(e.getMessage());
        }
        // флоат массив
        SwapArrayData.ArrayData<Float> arrayFloat = new SwapArrayData.ArrayData<Float>(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f);
        System.out.print("\nOriginal Float Array: ");
        arrayFloat.printArray();
        try {
            arrayFloat.swapArrayData(5,6);
            System.out.print("Swaped Float Array: ");
            arrayFloat.printArray();
            System.out.println("Swaped Elements: 5 and 6");
        } catch (MyWrongIndexException e) {
            System.out.println(e.getMessage());
        }
        // дабл массив - ОШИБКА В ИНДЕКСАХ
        SwapArrayData.ArrayData<Double> arrayDouble = new SwapArrayData.ArrayData<Double>(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        System.out.print("\nOriginal Double Array: ");
        arrayDouble.printArray();
        try {
            arrayDouble.swapArrayData(6,15);
            System.out.print("Swaped Double Array: ");
            arrayDouble.printArray();
            System.out.print("Swaped Elements: 6 and 15");
        } catch (MyWrongIndexException e) {
            System.out.println(e.getMessage());
        }
        // символьный массив
        SwapArrayData.ArrayData<Character> arrayCharacter = new SwapArrayData.ArrayData<Character>('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i');
        System.out.print("\nOriginal Character Array: ");
        arrayCharacter.printArray();
        try {
            arrayCharacter.swapArrayData(3,5);
            System.out.print("Swaped Character Array: ");
            arrayCharacter.printArray();
            System.out.println("Swaped Elements: 3 and 5");
        } catch (MyWrongIndexException e) {
            System.out.println(e.getMessage());
        }
        // булеан массив
        SwapArrayData.ArrayData<Boolean> arrayBoolean = new SwapArrayData.ArrayData<Boolean>(true, true, true, false, false, false, false);
        System.out.print("\nOriginal Boolean Array: ");
        arrayBoolean.printArray();
        try {
            arrayBoolean.swapArrayData(6,2);
            System.out.print("Swaped Boolean Array: ");
            arrayBoolean.printArray();
            System.out.println("Swaped Elements: 6 and 2");
        } catch (MyWrongIndexException e) {
            System.out.println(e.getMessage());
        }
	// Задание 2
        System.out.println ("\nЗадание 2 (про фрукты)");
        Apple apple = new Apple(); // создаём яблоко
        Orange orange = new Orange(); // создаём апельсин
        Box<Apple> appleBox1 = new Box<Apple>(apple,25.0f, 6); // создаем 1-ю коробку для яблок
        Box<Apple> appleBox2 = new Box<Apple>(apple,30.0f, 4); // создаем 2-ю коробку для яблок
        Box<Apple> appleBox3 = new Box<Apple>(apple,15.0f, 6); // создаем 3-ю коробку для яблок
        Box<Orange> orangeBox1 = new Box<Orange>(orange,20.0f, 4); // создаем 1-ю коробку для апельсинов
        System.out.println ("\nВ созданной коробке 1 сейчас " + appleBox1.getCounts() + " яблок(а). Её вес " +
                appleBox1.getBoxWeight() + " (" + appleBox1.getWeightLimit() + " max)");
        System.out.println ("В созданной коробке 2 сейчас " + appleBox2.getCounts() + " яблок(а). Её вес " +
                appleBox2.getBoxWeight() + " (" + appleBox2.getWeightLimit() + " max)");
        System.out.println ("В созданной коробке 3 сейчас " + appleBox3.getCounts() + " яблок(а). Её вес " +
                appleBox3.getBoxWeight() + " (" + appleBox3.getWeightLimit() + " max)");
        System.out.println ("Всозданной коробке 1 сейчас " + orangeBox1.getCounts() + " апельсин(ов). Её вес " +
                orangeBox1.getBoxWeight() + " (" + orangeBox1.getWeightLimit() + " max)");

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
        System.out.println ("В коробке 1 стало " + appleBox1.getCounts() + " яблок(а). Её вес " +
                appleBox1.getBoxWeight() + " (" + appleBox1.getWeightLimit() + " max)");
        System.out.println ("\nПытаемся добавить в 1-ю коробку еще 6 яблок");
        try {
            appleBox1.addFruits(6);
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("В коробке 1 стало " + appleBox1.getCounts() + " яблок(а). Её вес " +
                appleBox1.getBoxWeight() + " (" + appleBox1.getWeightLimit() + " max)");
        System.out.println ("\nПытаемся добавить в 1-ю коробку еще 15 яблок");
        try {
            appleBox1.addFruits(15);
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("В коробке 1 осталось " + appleBox1.getCounts() + " яблок(а). Её вес " +
                appleBox1.getBoxWeight() + " (" + appleBox1.getWeightLimit() + " max)");
        System.out.println ("\nПытаемся пересыпать из 2-й коробки яблок в 1-ю коробку яблок");
        try {
            appleBox1.emptyBoxToBox(appleBox2); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 1 стало " + appleBox1.getCounts() + " яблок(а). Её вес " +
                    appleBox1.getBoxWeight() + " (" + appleBox1.getWeightLimit() + " max)");
            System.out.println ("В коробке 2 стало " + appleBox2.getCounts() + " яблок(а). Её вес " +
                    appleBox2.getBoxWeight() + " (" + appleBox2.getWeightLimit() + " max)");
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nПытаемся пересыпать из 3-й коробки яблок в 1-ю коробку яблок");
        try {
            appleBox1.emptyBoxToBox(appleBox3); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 1 стало " + appleBox1.getCounts() + " яблок(а). Её вес " +
                    appleBox1.getBoxWeight() + " (" + appleBox1.getWeightLimit() + " max)");
            System.out.println ("В коробке 3 стало " + appleBox3.getCounts() + " яблок(а). Её вес " +
                    appleBox3.getBoxWeight() + " (" + appleBox3.getWeightLimit() + " max)");
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nПытаемся пересыпать из 3-й коробки яблок во 2-ю коробку яблок");
        try {
            appleBox2.emptyBoxToBox(appleBox3); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 2 стало " + appleBox2.getCounts() + " яблок(а). Её вес " +
                    appleBox2.getBoxWeight() + " (" + appleBox2.getWeightLimit() + " max)");
            System.out.println ("В коробке 3 стало " + appleBox3.getCounts() + " яблок(а). Её вес " +
                    appleBox3.getBoxWeight() + " (" + appleBox3.getWeightLimit() + " max)");
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nПытаемся пересыпать из 1-й коробки апельсин во 2-ю коробку яблок");
        try {
            appleBox2.emptyBoxToBox(orangeBox1); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 2 стало " + appleBox2.getCounts() + " яблок(а). Её вес " +
                    appleBox2.getBoxWeight() + " (" + appleBox2.getWeightLimit() + " max)");
            System.out.println ("В коробке 1 стало " + orangeBox1.getCounts() + " апельсин(ов). Её вес " +
                    orangeBox1.getBoxWeight() + " (" + orangeBox1.getWeightLimit() + " max)");
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nПытаемся пересыпать из 2-й коробки яблок во 1-ю коробку апельсинов");
        try {
            orangeBox1.emptyBoxToBox(appleBox2); // пересыпаем из коробки в коробку
            System.out.println ("В коробке 1 стало " + orangeBox1.getCounts() + " апельсин(ов). Её вес " +
                    orangeBox1.getBoxWeight() + " (" + orangeBox1.getWeightLimit() + " max)");
            System.out.println ("В коробке 2 стало " + appleBox2.getCounts() + " яблок(а). Её вес " +
                    appleBox2.getBoxWeight() + " (" + appleBox2.getWeightLimit() + " max)");
        } catch (MyBoxOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println ("\nИТОГОВОЕ СОСТОЯНИЕ КОРОБОК:");
        System.out.println ("В коробке 1 сейчас " + appleBox1.getCounts() + " яблок(а). Её вес " +
                appleBox1.getBoxWeight() + " (" + appleBox1.getWeightLimit() + " max)");
        System.out.println ("В коробке 2 сейчас " + appleBox2.getCounts() + " яблок(а). Её вес " +
                appleBox2.getBoxWeight() + " (" + appleBox2.getWeightLimit() + " max)");
        System.out.println ("В коробке 3 сейчас " + appleBox3.getCounts() + " яблок(а). Её вес " +
                appleBox3.getBoxWeight() + " (" + appleBox3.getWeightLimit() + " max)");
        System.out.println ("В коробке 1 сейчас " + orangeBox1.getCounts() + " апельсин(ов). Её вес " +
                orangeBox1.getBoxWeight() + " (" + orangeBox1.getWeightLimit() + " max)");
        }
}