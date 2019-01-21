package Task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Создаем массив с начальными элементами
        String[] testarr = new String[10];
        testarr[0] = "hi";
        testarr[1] = "hello";
        testarr[2] = "bye";
        testarr[3] = "hi";
        testarr[4] = "howdy?";
        testarr[5] = "fine!";
        testarr[6] = "weather is nice";
        testarr[7] = "true";
        testarr[8] = "bye";
        testarr[9] = "thank you";
        //Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        //Для этого приведем массив к HashSet
        LinkedHashSet<String> hs = new LinkedHashSet<>(Arrays.asList(testarr));
        System.out.println("Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем): \n" + hs);
        System.out.println();

        //Посчитать, сколько раз встречается каждое слово.

        //Приведем наш тестовый массив к виду листа чтобы посчитать дублирующиеся элементы в коллекции
        ArrayList<String> al = new ArrayList<>(Arrays.asList(testarr));
        //Создаем новый массив в котором будут храниться элементы и колличество их повторений
        String[] newarr = new String[testarr.length];
        for (int i = 0; i < testarr.length; i++) {
            newarr[i] = (testarr[i] + " " + Collections.frequency(al, testarr[i]));
        }
        //Из полученного массива получаем только уникальные элементы
        LinkedHashSet<String> copies = new LinkedHashSet<>(Arrays.asList(newarr));
        System.out.println("Посчитать, сколько раз встречается каждое слово: \n" + copies);


    }
}
