import java.util.Arrays;
import java.util.Scanner;

/*7. **** Написать метод, которому на вход подается одномерный массив и число n
(может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
Вышедшие за границу элементы отбрасываются, пустые места заполнять нулями. Нельзя пользоваться вспомогательными массивами.*/
public class Task7 {
    public static void main(String[] args) {
        int[] arr7 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Исходный массив " + Arrays.toString(arr7));
        System.out.println("Введите число от " + (0 - arr7.length) + " До " + arr7.length + ". На столько будут сдвинуты элементы массива");
        System.out.println("Если введенное число отрицательное, элементы будут сдвинуты влево, если положительное, вправо.");
        Scanner scanner = new Scanner(System.in);
        int shiftnum = scanner.nextInt();
        if (shiftnum > arr7.length || (0 - shiftnum > arr7.length)) {
            System.out.println("Введенное число вне диапазона, перезапустите приложение и попробуйте еще раз.");
        } else {
            arrayShift(arr7, shiftnum);
            System.out.println("Результат: " + Arrays.toString(arr7));
        }

    }

    private static void arrayShift(int[] a, int b) {
        if (b > 0) {
            for (int i = a.length - 1; i >= b; i--) {
                a[i] = a[i - b];
            }
            for (int j = 0; j < b; j++) {
                a[j] = 0;
            }
        } else if (b < 0) {
            b = 0 - b;
            for (int i = 0; i <=a.length-b-1 ; i++) {
                a[i] = a[i+b];
            }
            for (int j = a.length -1; j >a.length-b-1 ; j--) {
                a[j] = 0;
            }
        }
    }
}

