import java.util.Arrays;

//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
public class Task4 {

    public static void main(String[] args) {
        int[][] arr3 = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    arr3[i][j] = 1;
                }
            }
        }
        System.out.println("Результирующий массив " + Arrays.deepToString(arr3));
    }
}

