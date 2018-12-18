import java.text.MessageFormat;
import java.util.Random;
import java.util.Scanner;

public class XO_Game {
    public static final int MAP_SIZE = 5;
    public static String[][] map = new String[MAP_SIZE][MAP_SIZE];
    public static final int DOTS_TO_WIN = 4;

    public static final String DOT_EMPTY = "*";
    public static final String DOT_X = "X";
    public static final String DOT_O = "O";

    public static void main(String[] args) {
        initMap();
        while (true) {
            System.out.println("Your Turn");
            printMap();
            humanTurn();
            checkWin(DOT_X);
            checkFull();
            if (checkWin(DOT_X)) {
                System.out.println("Human Win!");
                break;
            }
            if (checkFull()) {
                System.out.println("Ничья");
                break;
            }
            System.out.println("Computer Turn");
            computerTurn();
            checkFull();
            checkWin(DOT_O);
            if (checkWin(DOT_O)) {
                System.out.println("Computer Win!");
                break;
            }
            if (checkFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        printMap();
        System.out.println("Game Over!");
    }
//Метод выводит карту на экран
    private static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= MAP_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < MAP_SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
//Метод делает ход компьютера
    private static void computerTurn() {
        Random random = new Random();
        int row;
        int column;
        do {
            row = random.nextInt(MAP_SIZE);
            column = random.nextInt(MAP_SIZE);
        } while (isCellNotValid(row, column));
        System.out.println(
                MessageFormat.format("Компьютер походил в точку {0} {1}",
                        row + 1, column + 1));
        map[row][column] = DOT_O;

    }
//Метод проверяет, доступна ли клетка для хода
    public static boolean isCellNotValid(int row, int column) {
        if (row < 0 || row >= MAP_SIZE || column < 0 || column >= MAP_SIZE) {
            return true;
        }
        // Сравнивать строки нужно только методом equals()
        if (map[row][column].equals(DOT_EMPTY)) {
            return false;
        }
        return true;
    }
//Метод проверяет есть ли на карте пустые клетки
    private static boolean checkFull() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
//Метод проверяет наличие выигрышных комбинаций на поле
    private static boolean checkWin(String symb) {
        if (columnWin(symb)||rowWin(symb)||diagonalAWin(symb)||diagonalBWin(symb)||subdiagonalAWin(symb)||subdiagonalBWin(symb)||subdiagonalCWin(symb)||subdiagonalDWin(symb)) {
            return true;
        } else {
            return false;
        }
    }
//Метод запрашивает координаты хода у игрока
    private static void humanTurn() {
        Scanner scanner = new Scanner(System.in);
        int row;
        int column;
        do {
            System.out.println("Введите координаты хода в формате X и Y, \n" +
                    "где X - номер строки, а Y - номер колонки");
            row = scanner.nextInt() - 1;
            column = scanner.nextInt() - 1;
        } while (isCellNotValid(row, column));
        map[row][column] = DOT_X;
    }
//Метод инициализирует карту
    private static void initMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
//Метод проверяет выйгрышные комбинации по строкам
    public static boolean rowWin(String a) {
        for (int i = 0; i < MAP_SIZE; i++) {
            int winCounter = 0;
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[i][j] == a) {
                    winCounter += 1;
                    if (winCounter == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //Метод проверяет выйгрышные комбинации по столбцам
    public static boolean columnWin(String a) {
        for (int i = 0; i < MAP_SIZE; i++) {
            int winCounter = 0;
            for (int j = 0; j < MAP_SIZE; j++) {
                if (map[j][i] == a) {
                    winCounter += 1;
                    if (winCounter == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }return false;
    }
    //Метод проверяет выйгрышные комбинации по первой диагонали
    public static boolean diagonalAWin(String a) {
        int winCounter = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            if (map[i][i] == a) {
                winCounter += 1;
            }
        }
        return winCounter == DOTS_TO_WIN;
    }
    //Метод проверяет выйгрышные комбинации по по второй диагонали
    public static boolean diagonalBWin(String a) {
        int winCounter = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (i + j == (MAP_SIZE - 1) && map[i][j] == a) {
                    winCounter += 1;
                }
            }

        }
        return winCounter == DOTS_TO_WIN;
    }
//Далее идут 4 метода, которые проверяет выйгрышные комбинации по сабдиагоналям
    public static boolean subdiagonalAWin(String a) {
        int winCounter = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (j - i == 1 && map[i][j] == a) {
                    winCounter += 1;
                }
            }
        }
        return winCounter == DOTS_TO_WIN;
    }

    public static boolean subdiagonalBWin(String a) {
        int winCounter = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (i - j == 1 && map[i][j] == a) {
                    winCounter += 1;
                }
            }
        }
        return winCounter == DOTS_TO_WIN;
    }

    public static boolean subdiagonalCWin(String a) {
        int winCounter = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (i + j == 3 && map[i][j] == a) {
                    winCounter += 1;
                }
            }
        }
        return winCounter == DOTS_TO_WIN;
    }

    public static boolean subdiagonalDWin(String a) {
        int winCounter = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (i + j == 5 && map[i][j] == a) {
                    winCounter += 1;
                }
            }
        }
        return winCounter == DOTS_TO_WIN;
    }
}
