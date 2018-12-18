import java.util.Scanner;

//1. Создать пустой проект в IntelliJ IDEA и прописать метод main();

public class Main {
    //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    byte mybyte = -128;
    short myshort = -32768;
    int myint = -10;
    long mylong = 999999999L;
    float myfloat = 12.34f;
    double mydouble = 33.333;
    boolean myboolean = true;
    char mychar = 'a';
    String mystring = "Hello World!";

    public static void main(String[] args) {
        //init task 3
        System.out.println("task 3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;");
        math(args);
        //init task 4
        System.out.println("task 4. Метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;");
        System.out.println("task 4. enter first number");
        Scanner scanner1 = new Scanner(System.in);
        int num1 = scanner1.nextInt();
        System.out.println("task 4. enter second number");
        Scanner scanner2 = new Scanner(System.in);
        int num2 = scanner2.nextInt();
        int sum = num1 + num2;

        check(sum);
        System.out.println("task 4 returns " + check(sum));
        //init task 5
        System.out.println("task 5. это метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное" + "enter integer number");
        Scanner scanner3 = new Scanner(System.in);
        int inputnumber = scanner3.nextInt();

        task5(inputnumber);
        System.out.println(task5(inputnumber));

        //init task 6
        System.out.println("task 6. метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное");
        Scanner scanner4 = new Scanner(System.in);
        int arg = scanner4.nextInt();

        task6(arg);
        System.out.println(task6(arg));

        //init task 7
        System.out.println("Введите ваше имя, метод поздоровается!");
        Scanner scanner5 = new Scanner(System.in);
        String name = scanner5.next();

        task7(name);

        //init task 8
        System.out.println("Введите год, метод оперделит високосный ли он");
        Scanner scanner6 = new Scanner(System.in);
        int year = scanner6.nextInt();

        task8(year);
        System.out.println(task8(year));
    }


    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    private static void math(String[] args) {
        int a = 2;
        int b = 10;
        int c = 4;
        int d = 1;

        int result;
        result = a * (b + (c / d));
        System.out.println("2 * (10 + (4 / 1)) = " + result);
        //result should be 28

    }

    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    private static boolean check(int sum) {
        return (sum >= 10 && sum <= 20);

    }

    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    private static String task5(int inputnumber) {
        if (inputnumber >= 0) {
            return "it is positive";
        } else {
            return "it is negotive";
        }
    }

    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    private static boolean task6(int arg) {
        return (arg < 0);
    }

    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    private static void task7(String name) {
        System.out.println("Привет," + name + "!");
    }

    //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    private static String task8(int year) {
        if (((year % 4 != 0) || (year % 100 == 0)) & (year % 400 != 0)) {
            return "Не Високосный";
        } else {
            return "Високосный";
        }
    }
}
