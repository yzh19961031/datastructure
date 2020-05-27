/**
 * 测试方法
 * @author Y
 * @date 2020/5/27
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 15; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        System.out.println("stack peek is "+arrayStack.peek());
        System.out.println("stack pop is "+arrayStack.pop());
        System.out.println("after pop "+arrayStack);
    }
}
