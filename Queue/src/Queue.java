/**
 * 队列
 * @author Y
 * @date 2020/5/27
 */
public interface Queue<T> {
    void offer(T t);

    T poll();

    T peek();

    int getSize();

    boolean isEmpty();
}
