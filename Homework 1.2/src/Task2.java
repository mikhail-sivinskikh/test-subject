//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] arr1 = new int[8];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i * 3;
        }
        System.out.println("Результирующий массив " + Arrays.toString(arr1));

    }
}
