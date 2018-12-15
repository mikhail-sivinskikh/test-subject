import java.text.Format;
import java.text.MessageFormat;

public class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    //Конструктор по умолчанию
    public Employee() {
        name = "Иванов Иван Иванович";
        position = "слесарь";
        email = "ivan@mail.ru";
        phone = "89015938716";
        salary = 25000;
        age = 40;
    }

    //Конструктор
    public Employee(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    //Метод выводит информацию о сотруднике
    public void getEmployee(){
        System.out.println(MessageFormat.format("ФИО: {0}, должность: {1}, email: {2}, Номер телефона: {3}, Зарпалата: {4}, Возраст:{5}",
                this.name, this.position, this.email, this.phone, this.salary, this.age));
    }

    public int getAge() {
        return age;
    }
}
