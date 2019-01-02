public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        System.out.println("Проверим, сможет ли первая кошка пробежать 10 метров");
        System.out.println(cat1.run(10));
        System.out.println("Проверим, сможет ли вторая кошка пробежать 10 метров");
        System.out.println(cat2.run(10));
        System.out.println("Проверим, сможет ли первая кошка проплыть 1 метр");
        System.out.println(cat1.swim(1));
        System.out.println("Проверим, сможет ли вторая кошка проплыть 1 метр");
        System.out.println(cat2.swim(1));
        System.out.println("Проверим, сможет ли первая кошка прыгнуть на 1 метр");
        System.out.println(cat1.jump(1));
        System.out.println("Проверим, сможет ли вторая кошка прыгнуть на 1 метр");
        System.out.println(cat2.jump(1));
        System.out.println();
        System.out.println("Проверим, сможет ли первая собака пробежать 100 метров");
        System.out.println(dog1.run(100));
        System.out.println("Проверим, сможет ли вторая собака пробежать 100 метров");
        System.out.println(dog2.run(100));
        System.out.println("Проверим, сможет ли первая собака проплыть 2 метра");
        System.out.println(dog1.swim(2));
        System.out.println("Проверим, сможет ли вторая собака проплыть 2 метра");
        System.out.println(dog2.swim(2));
        System.out.println("Проверим, сможет ли первая собака прыгнуть на 1 метр");
        System.out.println(dog1.jump(1));
        System.out.println("Проверим, сможет ли вторая собака прыгнуть на 1 метр");
        System.out.println(dog2.jump(1));
    }
}
