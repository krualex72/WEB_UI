package lesson5;

import java.io.File;

public class HomeWork5 {

    public static void main(String[] args) {
	//  Реализовать сохранение данных в csv файл;
        //2. Реализовать загрузку данных из csv файла. Файл читается целиком.
        //Структура csv файла:
        //| Строка заголовок с набором столбцов |
        //| Набор строк с целочисленными значениями |
        //| * Разделитель между столбцами - символ точка с запятой (;) |
        //
        //Пример:
        //Value 1;Value 2;Value 3
        //100;200;123
        //300,400,500
        //Для хранения данных использовать класс вида:
        //public class AppData {
        //  private String[] header;
        //  private int[][] data;
        //
        // // ...
        //}
        //Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
        System.out.println("Задание 1");
        String[] header = {"NumberID", "CodeITN", "Salary", "Age"};
        int[][] data = {{1, 78569856, 150000, 27},
                {2, 78569789, 155000, 31},
                {3, 78569368, 162000, 28},
                {4, 78569449, 158000, 23},
                {5, 78569773, 179000, 35}
        };
        File fileCSV = new File("src/lesson5/h_work5_task1.csv");

        System.out.println(fileCSV.getName());
        System.out.println(fileCSV.exists());
        System.out.println(fileCSV.isDirectory());

    }
}


