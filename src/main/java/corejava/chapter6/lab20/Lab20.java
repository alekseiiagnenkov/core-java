package corejava.chapter6.lab20;

public class Lab20 {
    public static void main(String[] args) {
        print(repeat(5, 1, 2, 3, 4));
    }

    @SafeVarargs
    public static <T> T[] repeat(int n, T... objs) {
        T[] result = (T[]) new Object[n * objs.length];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < objs.length; j++) {
                result[i * n + j] = objs[j];
            }
        }
        return result;
    }

    public static <T> void print(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
