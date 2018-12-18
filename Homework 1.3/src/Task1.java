import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int goplay = 0;//переменная для определения, готов ли игрок продолжить игру
        do {
            System.out.println("Программа загадала число от 0 до 9, попробуйте его отгадать!");
            int guessnum = (int) Math.round(Math.random() * 9);//Загадываем число
            int check = 3;//Задаем число попыток
            do {
                System.out.println("У вас осталось попыток: " + check);
                Scanner scan = new Scanner(System.in);
                int usertry = scan.nextInt();
                if (usertry == guessnum) {
                    System.out.println("Вы угадали!");//В случае, если игрок угадал, прерываем цикл, выводим информацию о выигрыше
                    break;
                } else if (usertry > guessnum) {
                    System.out.println("Загаданное число меньше.");//Если число меньше, убираем 1 попытку, выводим информацию, что число меньше
                    check--;
                } else if (usertry < guessnum) {
                    System.out.println("Загаданное число больше.");//Если число больше, убираем 1 попытку, выводим информацию, что число больше
                    check--;
                }
            }
            while (check > 0);//повторяем пока попытки есть
            if (check == 0) {
                System.out.println("Попытки исчерпаны. Вы проиграли.");//когда они заканчиваются, игрок проигрывает
            }
            System.out.println("Сыграем еще раз? 1 – да / 0 – нет");//спрашиваем, готов ли игрок сыграть еще раз
            Scanner scanner1 = new Scanner(System.in);
            goplay = scanner1.nextInt();
        }
        while (goplay == 1);//пока игрок не откажется играть, запускаем игру сначала
    }
}


