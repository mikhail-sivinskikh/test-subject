import java.util.Arrays;

//5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
public class Task5 {

    public static void main(String args[]) {
        int[] arrtest = new int[]{0, 1, 20, -5, -1};
        System.out.println("Исходный массив " + Arrays.toString(arrtest));
        int min = arrtest[0];
        int max = arrtest[0];
        for (int i = 0; i < arrtest.length; i++) {
            if (arrtest[i] < min) {
                min = arrtest[i];
            }
        }
        System.out.println("Наименьший элемент массива = " + min);

        for (int j = 0; j < arrtest.length; j++) {
            if (arrtest[j] > max) {
                max = arrtest[j];
            }
        }
        System.out.println("Наибольший элемент массива = " + max);
    }
}