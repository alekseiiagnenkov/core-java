package corejava.chapter2.lab16_17;

public class Lab16 {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        System.out.println(queue.get());
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
    }
}