import java.util.Arrays;

//1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
public class Task1 {
    public static void main(String[] args) {
        int[] arrtask1 = new int[]{1, 0, 0, 1, 1, 1, 0};
        System.out.println("Исходный массив " + Arrays.toString(arrtask1));
        changer(arrtask1);
        System.out.println("Результирующий массив " + Arrays.toString(arrtask1));
    }

    private static void changer(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }

        }
    }
}