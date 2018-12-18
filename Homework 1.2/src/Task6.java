import java.util.Arrays;

/*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
*/
public class Task6 {
    public static void main(String[] args) {
        int[] testarr = new int[]{1, 7, 1, 4, 5};
        System.out.println("Исходный массив " + Arrays.toString(testarr));
        System.out.println("Метод вернул " + checkBalance(testarr));

    }

    private static boolean checkBalance(int[] a) {
        boolean result = false;
        int leftsumm = a[0];
        int rightsumm = 0;
        for (int i = a.length - 1; i > 0; i--) {
            rightsumm += a[i];
        }
        if (leftsumm > rightsumm) {
            result = false;
        } else if (leftsumm == rightsumm) {
            result = true;
        } else if (rightsumm > leftsumm && a.length <= 2) {
            result = false;
        } else if (rightsumm > leftsumm && a.length > 2) {
            for (int i = 1; i < a.length - 1; i++) {
                leftsumm += a[i];
                rightsumm -= a[i];
                if (leftsumm == rightsumm) {
                    result = true;
                }
            }
        }
        return result;
    }
}