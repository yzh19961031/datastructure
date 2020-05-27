/**
 * 栈接口
 * @author Y
 * @date 2020/5/27
 */
public interface Stack<T> {
    void push(T data);

    T pop();

    T peek();

    boolean isEmpty();

    int getSize();
}
