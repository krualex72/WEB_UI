package com.company;

public class HomeWork2 {

    public static void main(String[] args) {
        String[][] arrayCorrect = { // корректный массив 4*4
                {"15", "12", "218", "579"},
                {"0", "896", "423", "123"},
                {"1", "28", "185", "955"},
                {"888", "56", "299", "459"}
        };
        String arrayName1 = "arrayCorrect";

        String[][] arrayWrongContent = { // массив 4*4 с недопустимыми символами
                {"15", "12", "a", "579"},
                {"0", "896", "423", "123"},
                {"1", "&", "185", "955"},
                {"888", "56", "299", "459"}
        };
        String arrayName2 = "arrayWrongContent";

        String[][] arrayWrongDimention = { // массив 5*4
                {"15", "12", "218", "579", "222"},
                {"0", "896", "423", "123", "333"},
                {"1", "28", "185", "955", "444"},
                {"888", "56", "299", "459", "555"}
        };
        String arrayName3 ="arrayWrongDimention";

        try {
            System.out.println("Сумма ячеек массива " + arrayName3 + " = " + convertAndSummArrayData(arrayName3, arrayWrongDimention));
        } catch (MyArrayDataException e1) {
            System.err.println(e1.getMessage());
        } catch (MyArraySizeException e2){
            System.err.println(e2.getMessage());
        }

        try {
            System.out.println("Сумма ячеек массива " + arrayName2 + " = " + convertAndSummArrayData(arrayName2, arrayWrongContent));
        } catch (MyArrayDataException e1) {
            System.err.println(e1.getMessage());
        } catch (MyArraySizeException e2){
            System.err.println(e2.getMessage());
        }

        try {
            System.out.println("Сумма ячеек массива " + arrayName1 + " = " + convertAndSummArrayData(arrayName1, arrayCorrect));
        } catch (MyArrayDataException e1) {
            System.err.println(e1.getMessage());
        } catch (MyArraySizeException e2){
            System.err.println(e2.getMessage());
        }
    }

    public static int convertAndSummArrayData(String arrName, String arr[][]) throws MyArraySizeException, MyArrayDataException{
        int summOfCells = 0;
        if (arr[0].length != 4 || arr.length != 4) throw new MyArraySizeException("Неправильный размер массива " + arrName);
        // System.out.println("Number of colls " + arr[0].length); // вывод на печить количества столбцов массива
        // System.out.println("Number of lines " + arr.length); // вывод на печать количнства строк массива
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (!isNumber(arr[i][j])) throw new MyArrayDataException("Неправильные данные в ячейке [" + i + "][" + j + "] массива " + arrName);
                summOfCells += Integer.valueOf(arr[i][j]);
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