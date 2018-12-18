import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int randomizer = (int) Math.round(Math.random() * words.length);
        String secret = words[randomizer]; //загадываем слово
        boolean enough = false; //переменная, указывающая, нужно ли нам снова пытаться угадать слово
        System.out.println("Компьютер загадал слово на английском языке, попробуйте его отгадать. Подсказка: загаданное слово это название фрукта или овоща. Введите свой ответ ниже:");
        do {
            Scanner scanner = new Scanner(System.in);
            String guess = scanner.nextLine();
            guess = guess.toLowerCase(); //переводим догадку в нижний регистр
            char[] guessfruit = guess.toCharArray(); //преобразуем догадку в символьный массив
            char[] secretfruit = secret.toCharArray(); //переводим загаданное слово в символьный массив
            int hashcounter = 0;//счетчик неверно угаданных букв в слове
            char[] resultmasked = new char[15];//массив, куда сложатся угаданные буквы и добавятся символы хэшей для маскировки
            if (guess.equals(secret)) {
                enough = true;//если слово угадано, выводим из цикла
                //Рассмотрим ситуацию, если загаданное слово длиннее разгадки от игрока
            } else if (guessfruit.length > secretfruit.length) {
                for (int i = 0; i < secretfruit.length; i++) {
                    if (secretfruit[i] != guessfruit[i]) {
                        secretfruit[i] = '#';//маскируем символ
                        hashcounter += 1;//добавляем 1 к счетчику неразгаданных букв
                    }
                }
                if (hashcounter == secretfruit.length) {
                    System.out.println("Вы не угадали, совпадений по буквам нет.");//если не разгадано ни 1 буквы из слова, выводим это
                } else {
                    for (int i = 0; i < secretfruit.length; i++) {
                        resultmasked[i] = secretfruit[i];//переливаем загаданное слово с уже скрытыми неразгаданными символами в массив
                    }
                    for (int i = secretfruit.length; i < resultmasked.length; i++) {
                        resultmasked[i] = '#';//добавляем хэши до 15 символов для маскировки
                    }
                    System.out.println(String.valueOf(resultmasked));//выводим замаскированный результат
                }
                //Теперь применим схожую конструкцию для ситуации, когда загаданное слово равно по длине или длиннее разгадки
            } else if (guess.length() <= secret.length()) {
                for (int i = 0; i < guessfruit.length; i++) {
                    if (secretfruit[i] != guessfruit[i]) {
                        secretfruit[i] = '#';
                        hashcounter += 1;
                    }
                }
                for (int i = guessfruit.length; i < secretfruit.length; i++) {
                    secretfruit[i] = '#';
                    hashcounter += 1;
                }
                if (hashcounter == secretfruit.length) {
                    System.out.println("Вы не угадали, совпадений по буквам нет.");
                } else {
                    for (int i = 0; i < secretfruit.length; i++) {
                        resultmasked[i] = secretfruit[i];
                    }
                    for (int i = secretfruit.length; i < resultmasked.length; i++) {
                        resultmasked[i] = '#';
                    }
                    System.out.println(String.valueOf(resultmasked));
                }
            }
        }
        while (enough != true);//Когда наконец игрок угадает слово, нужно выйти из цикла
        System.out.println("Вы угадали, загаданное слово было: " + secret);
    }
}
