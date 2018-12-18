public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int a){
        food -= a;
    }

    public int getFood() {
        return food;
    }
    //6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку
    public void addFood(int a){
        if(a<0){
            System.out.println("Не ешь из кошачей миски!");
        }else {
            food+=a;
            System.out.println("Миска пополнена, сейчас в ней находится это количество еды: "+food);
        }
    }
}
