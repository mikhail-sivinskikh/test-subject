public class Main {
    public static void main(String[] args) {
        System.out.println("Результат 1го метода: ");
        FirstClass f1 = new FirstClass();
        f1.run();
        System.out.println("Результат второго метода: ");
        SecondClass s1 = new SecondClass();
        s1.go();
    }

}
