/**
 * 基于动态数组实现队列
 * 实现与栈类似，只有出队列不一样，出队列有一个移位的操作，时间复杂度是o(n)
 * @author Y
 * @date 2020/5/27
 */
public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_SIZE = 10;

    private Object[] storage;
    private int size;

    public ArrayQueue() {
        this.storage = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public void offer(T t) {
        if (size == storage.length)
            resize(storage.length * 2);
        storage[size++] = t;

    }

    @Override
    public T poll() {
        if (size == 0)
            throw new IllegalArgumentException("queue is empty");
        @SuppressWarnings("unchecked")
        T res = (T) storage[0];
        for (int i = 0; i < size - 1; i++) {
            storage[i] = storage[i+1];
        }
        size --;
        return res;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (size == 0)
            throw new IllegalArgumentException("queue is empty");
        return (T) storage[0];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("queue [");
        for (int i = 0; i < size; i++) {
            sb.append(storage[i]);
            if(i != size-1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize(int newCapacity) {
        Object[] newStorage = new Object[newCapacity];
        System.arraycopy(storage, 0, newStorage, 0, size);
        storage = newStorage;
    }
}
