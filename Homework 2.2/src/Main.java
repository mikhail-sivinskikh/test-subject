import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String[][] newarr = new String[4][4];
    private static String[][] testarr = new String[4][5];
    private static Random random = new Random();

    public static void main(String[] args) {
        int result;
        System.out.println();
        do {
            System.out.println("Чтобы запустить вариант работы программы без ошибок, введите 1,\nЧтобы запустить вариант работы программы с MyArrayDataException, нажмите 2,\nЧтобы запустить вариант работы программы с MyArraySizeException, нажмите 3. ");
            System.out.println();
            Scanner scanner1 = new Scanner(System.in);
            result = scanner1.nextInt();
        } while (!userInput(result));
        if (result == 1) {
            fulfillArr(newarr); //Наполняем массив случайными числами переведенными в строки
            printArr(newarr); //Отображаем содержимое массива
            //Показываем корректную работу метода, суммирующего все элементы массива
            try {
                sumArr(newarr);
            } catch (MyArraySizeException | MyArrayDataException e) {
                e.printStackTrace();
            }
        } else if (result == 2) {
            //Меняем один элемент массива на строку не переводимую в число, после чего вызываем метод sumArr, он бросит MyArrayDataException
            fulfillArr(newarr);
            newarr[1][2] = "hi";
            printArr(newarr);
            try {
                sumArr(newarr);
            } catch (MyArraySizeException | MyArrayDataException e) {
                e.printStackTrace();
            }
        } else if (result == 3) {
            fulfillArr(testarr); //Наполняем массив случайными числами переведенными в строки
            printArr(testarr); //Отображаем содержимое массива
            //Вызываем метод sumArr для массива с некорректным числом элементов, который бросит MyArraySizeException
            try {
                sumArr(testarr);
            } catch (MyArraySizeException | MyArrayDataException e) {
                e.printStackTrace();
            }
        }


    }

    //Этот метод заполняет массив случайными числами переведенными в строки
    private static void fulfillArr(String[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = String.valueOf(random.nextInt(50));
            }
        }
    }

    //Этот метод выводит созданный массив в консоль
    private static void printArr(String[][] s) {
        System.out.println("Содержимое массива: ");
        for (String[] value : s) {
            for (String aValue : value) {
                System.out.print(aValue + "  ");
            }
            System.out.println();
        }
    }

    //Переводит строчные элементы массива в числа и суммирует их, в результате выводит сумму в консоль
    private static void sumArr(String[][] s) throws MyArraySizeException, MyArrayDataException {
        int theSumm = 0;
        if (s.length != 4 || s[s.length - 1].length != 4) {
            throw new MyArraySizeException("Array size is Incorrect! Expected array with size: 4x4, recieved array with size: " + s.length + "x" + s[s.length - 1].length);
        }
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                int[][] s1 = new int[s.length][s[i].length];
                try {
                    s1[i][j] = Integer.parseInt(s[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Array element \"" + s[i][j] + "\" cannot be parsed to integer!");
                }
                theSumm += s1[i][j];
            }
        }
        System.out.println("Сумма элементов массива = " + theSumm);
    }
    //Проверяем насколько корректен ввод пользователя
    private static boolean userInput(int a) {
        boolean isValid;
        switch (a) {
            case 1:
                isValid = true;
                break;
            case 2:
                isValid = true;
                break;
            case 3:
                isValid = true;
                break;
            default:
                isValid = false;
        }
        return isValid;
    }
}
