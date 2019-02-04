class FirstClass {


    //Первый метод просто бежит по массиву и вычисляет значения.
    void run() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }
}
