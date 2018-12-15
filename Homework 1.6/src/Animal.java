public abstract class Animal {



    public Animal() {

    }
    /*
     * 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
     * В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
     */
    public abstract boolean run(int a);

    public abstract boolean swim(int a);

    public abstract boolean jump(float a);
}
