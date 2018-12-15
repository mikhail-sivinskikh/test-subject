//1. Создать классы Собака и Кот с наследованием от класса Животное.
public class Dog extends Animal {
    public Dog() {
    }
//Собака бегает в разбросе от 0 до 500 метров
    @Override
    public boolean run(int a) {
        if (a < 0) {
            return false;
        } else
            return a <=  Math.round(Math.random()*500);
    }
//Собака плавает в разбросе от 0 до 10 метров
    @Override
    public boolean swim(int a) {
        if (a < 0) {
            return false;
        } else
            return a <=  Math.round(Math.random()*10);
    }
//Собака прыгает в разбросе от 0 до 0,5 метров
    @Override
    public boolean jump(float a) {
        if (a < 0) {
            return false;
        } else
            return a <=  Math.random()*0.5f;
    }
}

