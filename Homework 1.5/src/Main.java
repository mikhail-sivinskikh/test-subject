public class Main {
    public static void main(String[] args) {
        System.out.println("Проверим заполнение по умолчанию: ");
        Employee ivan = new Employee();
        ivan.getEmployee();
        System.out.println();
        System.out.println("Выведем в консоль информацию о сотрудниках старше 40:");
        Employee[] emploArray = new Employee[5];
        emploArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        emploArray[1] = new Employee("Alexandrov Pavel", "Housemaid", "alexxxn@mailbox.com", "844412317", 40000, 50);
        emploArray[2] = new Employee("Petrov Dima", "Salesman", "saledima@mailbox.com", "892212122", 20000, 27);
        emploArray[3] = new Employee("Sidorov Vitaliy", "CEO", "bigboss@mailbox.com", "890012345", 100000, 48);
        emploArray[4] = new Employee("Zaharova Maria", "Cleaning manager", "babamanya@mailbox.com", "892215512", 18000, 60);
        for (int i = 0; i < emploArray.length; i++) {
            if (emploArray[i].getAge() >= 40) {
                emploArray[i].getEmployee();
            }
        }
    }
}
