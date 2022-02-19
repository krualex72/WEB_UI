package lesson3;

import java.util.Arrays;

public class SwapArrayData {

    public static class ArrayData<T> { //  extends Array
        private T[] arrayT; // подразумеваем сам массив

        public ArrayData(T... arrayT) {
            this.arrayT = arrayT;
        }

        public T[] getArrayT() {
            return arrayT;
        }

        public void printArray() { // вывод массива на экран
            System.out.println(Arrays.toString(arrayT));
        }

        public void swapArrayData(int indexOne, int indexTwo) throws MyWrongIndexException {
            if (indexOne < 0 || indexOne > (arrayT.length-1) || indexTwo < 0 || indexTwo > (arrayT.length-1) ||
                indexOne == indexTwo) {
                throw new MyWrongIndexException("Заданные значения индексов не соответствуют размеру массива");
            }
            T bufferData = arrayT[indexOne];// переменная для хранения переносимой величины
            arrayT[indexOne] = arrayT[indexTwo];
            arrayT[indexTwo] = bufferData;
        }
    }
    public static void main(String[] args) {
        // строковый массив
        ArrayData<String> arrayString = new ArrayData<String>("cat", "dog", "monkey", "donkey", "eagle");
        System.out.print("Original String Array: ");
        arrayString.printArray();
        try {
            arrayString.swapArrayData(1,4);
        } catch (MyWrongIndexException e) {
            System.err.println(e.getMessage());
        }
        System.out.print("Swaped String Array: ");
        arrayString.printArray();
        // целочисленный массив
        ArrayData<Integer> arrayInteger = new ArrayData<Integer>(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.print("\nOriginal Integer Array: ");
        arrayInteger.printArray();
        try {
            arrayInteger.swapArrayData(1,5);
        } catch (MyWrongIndexException e) {
            System.err.println(e.getMessage());
        }
        System.out.print("Swaped Integer Array: ");
        arrayInteger.printArray();
        // флоат массив - ОШИБКА В ИНДЕКСЕ СПЕЦИАЛЬНО
        ArrayData<Float> arrayFloat = new ArrayData<Float>(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f);
        System.out.print("\nOriginal Float Array: ");
        arrayFloat.printArray();
        try {
            arrayFloat.swapArrayData(5,9);
            System.out.print("Swaped Float Array: ");
            arrayFloat.printArray();
        } catch (MyWrongIndexException e) {
            System.err.println(e.getMessage());
        }
        // дабл массив
        ArrayData<Double> arrayDouble = new ArrayData<Double>(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);
        System.out.print("\nOriginal Double Array: ");
        arrayDouble.printArray();
        try {
            arrayDouble.swapArrayData(6,5);
            System.out.print("Swaped Double Array: ");
            arrayDouble.printArray();
        } catch (MyWrongIndexException e) {
            System.err.println(e.getMessage());
        }
        // символьный массив
        ArrayData<Character> arrayCharacter = new ArrayData<Character>('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i');
        System.out.print("\nOriginal Character Array: ");
        arrayCharacter.printArray();
        try {
            arrayCharacter.swapArrayData(3,5);
            System.out.print("Swaped Character Array: ");
            arrayCharacter.printArray();
        } catch (MyWrongIndexException e) {
            System.err.println(e.getMessage());
        }
        // булеан массив
        ArrayData<Boolean> arrayBoolean = new ArrayData<Boolean>(true, true, true, false, false, false, false);
        System.out.print("\nOriginal Boolean Array: ");
        arrayBoolean.printArray();
        try {
            arrayBoolean.swapArrayData(6,2);
            System.out.print("Swaped Boolean Array: ");
            arrayBoolean.printArray();
        } catch (MyWrongIndexException e) {
            System.err.println(e.getMessage());
        }
        }

}


