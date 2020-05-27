/**
 * 测试方法
 * @author Y
 * @date 2020/5/27
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                array.addFirst(i);
            } else {
                array.addLast(i);
            }
        }
        System.out.println(array);
    }
}
