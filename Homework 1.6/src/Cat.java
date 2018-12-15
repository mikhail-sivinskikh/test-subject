//1. Создать классы Собака и Кот с наследованием от класса Животное.
public class Cat extends Animal {
    public Cat() {
    }

//Кот бегает в разбросе от 0 до 200 метров
    @Override
    public boolean run(int a) {
        if (a < 0) {
            return false;
        } else
            return a <= Math.round(Math.random()*200);
    }
//Кот плавает всегда 0 метров
    @Override
    public boolean swim(int a) {
        return a == 0;
    }
//Кот прыгает в разбросе от 0 до 2 метров
    @Override
    public boolean jump(float a) {
        if (a < 0) {
            return false;
        } else
            return a <=  Math.round(Math.random()*2f);
    }
}

