package lesson5;

import java.io.*;

public class HomeWork5 {

    public static void main (String[]args) {
        //Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
        System.out.println("Задание 1");
        String[] header = {"NumberID", "CodeITN", "Salary", "Age" }; // исходные данные для записи в файл
        int[][] data = {{1, 78569856, 150000, 27},
                {2, 78569789, 155000, 31},
                {3, 78569368, 162000, 28},
                {4, 78569449, 158000, 23},
                {5, 78569773, 179000, 36}
        };
        writeAppData(header, data); // записываем данные в файл

        System.out.println("\nЗадание 2");
        int[][] dataNew = new int[5][4]; // массив для считанных даных
        String[] headerNew = new String[4];
        AppData newAppData = new AppData(headerNew, dataNew);// создаем объект
        System.out.println("Данные ниже должны отсутствовать:");
        newAppData.printAppData(); // выводим хранящиеся в AppData значения (проверяем что пусто)
        readToAppData(newAppData); // читаем из файла в AppData
        System.out.println("Данные ниже прочитаны из файла:");
        newAppData.printAppData();// выводим хранящиеся в AppData значения
        // изменяем значения в массиве данных header
        headerNew = newAppData.getHeader();
        headerNew[0] = "ID";
        newAppData.setHeader(headerNew); // передаем в AppData массив header
        System.out.println("Данные ниже из AppData после внесения изменений (изменения в 0 ячкйке header):");
        newAppData.printAppData();// выводим хранящиеся в AppData новые значения
        saveToFile(newAppData); // записываем новые данные в файл
        System.out.println("Новые данные перезаписаны в файл!");
    }

    public static void writeAppData(String[] header, int[][] data){ // по идее можно передавать еще имя файла
        String headerStr; // переменная для формирования строки header
        String dataStr; // переменная для формирования строк data
        File fileCSV = new File("src/lesson5/h_work5_task1.csv");
        //System.out.println("Имя файла: " + fileCSV.getName()); // чистый эксперимент для закрепления занятия
        //System.out.println("Файл существует: " + fileCSV.exists());

        headerStr = header[0]; // формируем строку с данными header
        for (int i = 1; i < header.length; i++) {
            headerStr += (";" + header[i]);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/lesson5/h_work5_task1.csv"))) {
            writer.write(headerStr); // записываем строку header
            for (int i = 0; i < data.length; i++) {
                dataStr = "\n" + data[i][0]; // формируем построчно данные data
                for (int j = 1; j < data[0].length; j++) {
                    dataStr += (";" + data[i][j]);
                }
                writer.write(dataStr); // записываем построчно данные data
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл: " + fileCSV.getName() + " записан!");
    }

    public static void readToAppData(AppData newAppData) {
        int[][] dataNew = new int[5][4]; // массив для считанных даных
        String[] headerNew = new String[4];

        try (BufferedReader reader = new BufferedReader(new FileReader("src/lesson5/h_work5_task1.csv"))) {
            String str;
            for (int i = 0; (str = reader.readLine()) != null; i++) {
                if (i == 0) { // обрабатываем первую строку и записываем в строчный массив
                    headerNew = str.split(";");
                } else { // если строка не первая (т.е. уже значения int)
                    String[] dataNewStr = str.split(";");
                    for (int j = 0; j < dataNewStr.length; j++) {
                        if (isNumber(dataNewStr[j])) { // на всякий случай проверяем численное ли содержимое
                            dataNew[i - 1][j] = Integer.valueOf(dataNewStr[j]);
                        } else {
                            System.out.println("Данные имеют недопустимые (нечисленные) значения!");
                        }
                    }
                }
            }
            newAppData.setHeader(headerNew); // передаем в AppData массив header
            newAppData.setData(dataNew); // передаем в AppData массив data
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isNumber (String str){ // проверяем в строке только одни числа?
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    public static void saveToFile (AppData newAppData){ // перезапись данных в файл
        writeAppData(newAppData.getHeader(), newAppData.getData());
    }
}