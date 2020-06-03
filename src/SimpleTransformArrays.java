public class SimpleTransformArrays extends Thread {
    private static int size;
    static float[] simpleFloatArr;

    public SimpleTransformArrays(int size) {
        SimpleTransformArrays.size = size;
    }

    @Override
    public void run() {
        simpleFloatArr = createArr();
        simpleCount(simpleFloatArr);
    }

    static float[] createArr (){
        float[] arr = new float[size];
        for (int i = 0; i <size ; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    void simpleCount(float[] arr){
        long a = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        a = System.currentTimeMillis() - a;
        System.out.println("Simple count time " + a);
    }

}
