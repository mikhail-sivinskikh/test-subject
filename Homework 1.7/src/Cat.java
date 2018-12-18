public class Cat {
    private String name;
    private int appetite;
    //3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
    private boolean isHungry = true;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate a) {
        //2 Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
        //4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
        if (appetite > a.getFood()) {
            System.out.println("Еды в таредке не достаточно для насыщения котика " + name);
        } else {
            a.decreaseFood(appetite);
            isHungry = false;
        }
    }

    public boolean getHunger() {
        return isHungry;
    }

    public String getName() {
        return name;
    }
}
