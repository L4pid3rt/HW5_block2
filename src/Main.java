public class Main {
    static final int SIZE = 10000000;
    static final int H = SIZE/2;

    public static void main(String[] args) {
       SimpleTransformArrays simpleTransformArray = new SimpleTransformArrays(SIZE);
       HardTransformArrays hardTransformArrays = new HardTransformArrays(SIZE,H);

       simpleTransformArray.start();
       hardTransformArrays.start();

    }

}