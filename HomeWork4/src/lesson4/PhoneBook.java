package lesson4;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    HashMap<Long, String> phoneBookData = new HashMap<>(); // принципиально: ключ - номер телефона!

    public void addContact(String name, long phone) { // добавление контакта в список
        phoneBookData.put(phone, name);
    }

    public void getPhone(String name) { // получение номера телефона по фамилии
        String phones = "";
        System.out.print(name + " tel: ");
        for (Map.Entry<Long, String> o : phoneBookData.entrySet()) {
            if (o.getValue().equals(name)) {
                phones += (o.getKey()+" ");
            }
        }
        if (phones.equals("")) {
            System.out.println("- Такого контакта не существует!");
        } else {
            System.out.println(phones);
        }
    }
}
