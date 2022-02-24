package lesson4;

import java.util.*;

import static lesson4.PhoneBook.*;

public class HomeWork4 {

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

        System.out.println("\nЗадание 2");
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.addContact("Ivanov", 89266855869L);
        myPhoneBook.addContact("Petrov", 89261235869L);
        myPhoneBook.addContact("Sidorov", 89235896869L);
        myPhoneBook.addContact("Ivanov", 89256915869L);
        myPhoneBook.addContact("Vasiliev", 89056989869L);
        myPhoneBook.getPhone("Ivanov");
        myPhoneBook.getPhone("Ivanovм"); // несуществующий контакт
        myPhoneBook.getPhone("Sidorov");
    }
}
