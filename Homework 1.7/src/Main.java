public class Main {
    public static void main(String[] args) {
        //5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
        Cat[] catarr = new Cat[3];
        catarr[0] = new Cat("Barski", 51);
        catarr[1] = new Cat("Murzik", 64);
        catarr[2] = new Cat("Snezhok", 80);

        Plate plate1 = new Plate(160);
        for (int i = 0; i < catarr.length; i++) {
            catarr[i].eat(plate1);
            System.out.println("Кот " + catarr[i].getName() + " был у миски, остался ли он голоден: " + catarr[i].getHunger());
        }

    }
}
