package com.company;

public class Main {

    public static void main(String[] args) throws MyArraySizeException {
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
        System.out.println("The Summ of Cells = " + convertAndSummArrayData(arrayCorrect));
        System.out.println("The Summ of Cells = " + convertAndSummArrayData(arrayWrongContent));
        System.out.println("The Summ of Cells = " + convertAndSummArrayData(arrayWrongDimention));
    }

    public static int convertAndSummArrayData(String arr[][]) throws MyArraySizeException { //, MyArrayDataException{
        int summOfCells = 0;
        if (arr[0].length != 4 || arr.length != 4) throw new MyArraySizeException("Wrong Array Lenght!!!");
        System.out.println("Number of colls" + arr[0].length);
        System.out.println("Number of lines" + arr.length);
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                try {
                    summOfCells += Integer.valueOf(arr[i][j]);
                } catch (NumberFormatException e) {
                    System.err.println("Неправильный формат ячейки: ["+ i + "][" + j +"]");
                }
            }
        }
        return summOfCells;
    }
}