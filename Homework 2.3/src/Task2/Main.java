package Task2;

public class Main {
    public static void main(String[] args) {
        Phonebook book = new Phonebook();
        //Заполняем нашу телефонную книгу
        book.add("Ivanov", "88005553535");
        book.add("Police", "02");
        book.add("Ivanov", "89222220888");
        book.add("Petrov", "89194126981");
        book.add("Sinitsyn", "89899888890");
        book.add("Petrov", "88082203008");

        //Получаем телефоны однофамильцев Петровых
        book.get("Petrov");
    }
}
