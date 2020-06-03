public class HardTransformArrays extends Thread {
    private static int size;
    private static int h;
    static float[] hardFloatArr;

    public HardTransformArrays(int size, int h) {
        HardTransformArrays.size = size;
        HardTransformArrays.h = h;
    }

    @Override
    public void run() {
        hardFloatArr = createArr();
        hardTransform(hardFloatArr);

    }

    static float[] createArr() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        return arr;
    }

    static void hardTransform(float[] arr) {
        float[] firstTempArr = new float[h];
        float[] secondTempArr = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, firstTempArr, 0, h);
        System.arraycopy(arr, h, secondTempArr, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                firstTempArr[i] = (float) (firstTempArr[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < h; i++) {
                secondTempArr[i] = (float) (secondTempArr[i] * Math.sin(0.2f + i / 5)
                        * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstTempArr, 0, arr, 0, h);
        System.arraycopy(secondTempArr, 0, arr, h, h);

        a = System.currentTimeMillis() - a;

        System.out.println("Hard count time " + a);
    }


}
