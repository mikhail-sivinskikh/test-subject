package Task2;

import java.util.HashMap;

class Phonebook {
    private HashMap<String, String> phonebook = new HashMap<>();

    void add(String surname, String phonenumber) {
        if (!phonebook.containsKey(surname)) {
            phonebook.put(surname, phonenumber);
        } else {
            phonebook.put(surname, phonenumber + ", " + (phonebook.get(surname)));
        }
    }

    void get(String surname) {
        if (phonebook.containsKey(surname)) {
            System.out.println(surname +" - " + phonebook.get(surname));
        } else {
            System.out.println("Абонент не найден");
        }
    }

}
