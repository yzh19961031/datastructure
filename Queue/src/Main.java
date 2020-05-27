/**
 * 测试方法
 * @author Y
 * @date 2020/5/27
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 15; i++) {
            arrayQueue.offer(i);
        }
        System.out.println(arrayQueue);
        System.out.println("queue peek is "+arrayQueue.peek());
        System.out.println("queue poll is "+arrayQueue.poll());
        System.out.println("after poll "+arrayQueue);
    }
}
