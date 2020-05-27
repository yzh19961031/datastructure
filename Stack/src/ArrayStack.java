/**
 * 使用动态数组实现栈
 * @author Y
 * @date 2020/5/27
 */
public class ArrayStack<T> implements Stack<T> {

    private static final int DEFAULT_SIZE = 10; // 默认初始容量

    private Object[] storage;
    private int size;

    // 默认构造函数
    public ArrayStack() {
        this.storage = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    // 压栈
    @Override
    public void push(T data) {
        // 每次添加元素之前增加判断 如果超过数组长度进行扩容
        if (size == storage.length)
            resize(storage.length * 2);
        storage[size++] = data;
    }

    // 弹栈
    @Override
    public T pop() {
        if (isEmpty())
            throw new IllegalArgumentException("stack is empty");
        T res = (T) storage[size - 1];
        storage[size - 1] = null; // GC
        size--;
        return res;
    }

    // 查看栈顶元素
    @Override
    public T peek() {
        if (isEmpty())
            return null;
        return (T) storage[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private void resize(int newCapacity) {
        // 使用一个新数组代替原来的数组
        Object[] newStorage = new Object[newCapacity];
        System.arraycopy(storage,0,newStorage,0,size);
        storage = newStorage;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack [");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                sb.append(storage[i]+"]");
            } else {
                sb.append(storage[i]+",");
            }
        }
        return sb.toString();
    }

}
