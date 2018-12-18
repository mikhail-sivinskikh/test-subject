import java.util.Scanner;
//Как факультатив сделал решение для задачи №2 с перебором всех овощей и фруктов в "корзине", при угадывании а не случайно выбранного, алгоритмы сравнения с загаданным словом те, же, что и во 2 задании
public class Task2_extended {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Компьютер загадал набор фруктов и овощей на английском. Попробуйте отгадать, что есть в фруктовой корзине компьютера.  Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.");
        Scanner scanner = new Scanner(System.in);
        String guessfruit = scanner.nextLine();
        guessfruit = guessfruit.toLowerCase();
        char[] guess = guessfruit.toCharArray();
        char[] notForPrint = new char[15];
        for (int i = 0; i < notForPrint.length; i++) {
            notForPrint[i] = '#';
        }
        for (int i = 0; i < words.length; i++) {
            char[] given = words[i].toCharArray();
            if (guessfruit.equals(words[i])) {
                System.out.println("Верно! " + guessfruit);
                break;
            } else if (words[i].length() > guessfruit.length()) {
                for (int j = 0; j < guess.length; j++) {
                    if (guess[j] != given[j]) {
                        given[j] = '#';
                    }
                }
                for (int j = guess.length; j < words[i].length(); j++) {
                    given[j] = '#';
                }
                resultPrinter(given);
            } else if (words[i].length() <= guessfruit.length()) {
                for (int j = 0; j < given.length; j++) {
                    if (guess[j] != given[j]) {
                        given[j] = '#';
                    }
                }
                resultPrinter(given);
            }
        }
    }


    private static void resultPrinter(char[] a) {
        char[] resultToPrint = new char[15];
        int hashcounter = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '#') {
                hashcounter += 1;
            }
            resultToPrint[i] = a[i];
        }
        for (int j = a.length; j < resultToPrint.length; j++) {
            resultToPrint[j] = '#';
        }
        if (hashcounter!=a.length){
            System.out.println("Найдены совпадения букв: ");
            System.out.println(String.valueOf(resultToPrint));
        }
    }

}

