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
}


