package com.company;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] arrayCorrect = { // корректный массив 4*4
                {"15", "12", "218", "579"},
                {"0", "896", "423", "123"},
                {"1", "28", "185", "955"},
                {"888", "56", "299", "459"}
        };
        String[][] arrayWrongContent = { // массив 4*4 с недопустимыми символами
                {"15", "12", "a", "579"},
                {"0", "896", "423", "123"},
                {"1", "&", "185", "955"},
                {"888", "56", "299", "459"}
        };
        String[][] arrayWrongDimention = { // массив 5*4
                {"15", "12", "218", "579", "222"},
                {"0", "896", "423", "123", "333"},
                {"1", "28", "185", "955", "444"},
                {"888", "56", "299", "459", "555"}
        };

        try {
            System.out.println("Сумма ячеек массива = " + convertAndSummArrayData(arrayWrongDimention));
        } catch (MyArrayDataException e1) {
            System.err.println(e1.getMessage());
        } catch (MyArraySizeException e2){
            System.err.println(e2.getMessage());
        }

        try {
            System.out.println("Сумма ячеек массива = " + convertAndSummArrayData(arrayWrongContent));
        } catch (MyArrayDataException e1) {
            System.err.println(e1.getMessage());
        } catch (MyArraySizeException e2){
            System.err.println(e2.getMessage());
        }

        try {
            System.out.println("Сумма ячеек массива = " + convertAndSummArrayData(arrayCorrect));
        } catch (MyArrayDataException e1) {
            System.err.println(e1.getMessage());
        } catch (MyArraySizeException e2){
            System.err.println(e2.getMessage());
        }
    }

    public static int convertAndSummArrayData(String arr[][]) throws MyArraySizeException, MyArrayDataException{
        int summOfCells = 0;
        if (arr[0].length != 4 || arr.length != 4) throw new MyArraySizeException("Неправильный размер массива!");
        // System.out.println("Number of colls " + arr[0].length); // вывод на печить количества столбцов массива
        // System.out.println("Number of lines " + arr.length); // вывод на печать количнства строк массива
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (!isNumber(arr[i][j])) throw new MyArrayDataException("Неправильные данные в ячейке [" + i + "][" + j + "]!");
                summOfCells += Integer.valueOf(arr[i][j]);
//                try {
//                    summOfCells += Integer.valueOf(arr[i][j]);
//                } catch (NumberFormatException e) {
//                    System.err.println("Неправильный формат ячейки: ["+ i + "][" + j +"]");
//                    new MyArrayDataException("Wrong Array Data!!!");
//                }
            }
        }
        return summOfCells;
    }

    public static boolean isNumber(String str) { // проверяем в только одни числа?
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }
}