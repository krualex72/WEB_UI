package lesson4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // навеяно последними новостями
        System.out.println("Задание 1");
        String [] stikhBoomer = {"все", "мы", "герои", "фильмов", "про", "войну",
                "или", "про", "первый", "полёт", "на", "луну",
                "или", "про", "жизнь", "одиноких", "сердец",
                "у", "каждого", "фильма", "свой", "конец",
                "никого", "не", "жалко", "никого",
                "ни", "тебя", "ни", "меня", "ни", "его",
                "никого", "не", "жалко", "никого",
                "ни", "тебя", "ни", "меня", "ни", "его"
        };
        Set<String> originalWords = new LinkedHashSet<>(); // для определения только уникальных значений
        for (String i: stikhBoomer) { // перебираем исходный массив слов
            originalWords.add(i); // записываем LinkedHashSet
        }
        System.out.println(originalWords); // выводим LinkedHashSet (получаем оригинальные значаения)
        HashMap<String, Integer> wordsMap = new HashMap<>();
        Iterator<String> iter = originalWords.iterator(); // создаем итератор для LinkedHashSet
        while (iter.hasNext()) {
            wordsMap.put(iter.next(), 0); // записываем слово и его статистику - "0" по умолчанию
        }
        for (Map.Entry<String, Integer> w : wordsMap.entrySet()) { // перебираем HashMap
            for (String i: stikhBoomer) { // перебираеи исходный массив слов
                if (w.getKey().equals(i)) { // при совпадении ключа со словом в массиве
                    wordsMap.put(w.getKey(), w.getValue()+1);// увеличиваем статистику +1
                }
            }
            System.out.println(w.getKey() + ": " + w.getValue());
        }
    }
    // Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
    // В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать
    // номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае
    // однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
}
