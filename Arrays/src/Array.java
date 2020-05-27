/**
 * 动态数组
 * @author Y
 * @date 2020/5/27
 */
public class Array<T> {
    //默认容量
    private static final int DEFAULT_CAPACITY = 10;

    //默认存储的数组
    private Object[] data;

    //数组的大小
    private int size;

    public Array(int capacity) {
        this.data = new Object[capacity];
    }

    //提供默认的构造函数
    public Array() {
        this(DEFAULT_CAPACITY);
    }

    //是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加末尾元素
     * @param t
     */
    public void addLast(T t) {
        add(size,t);
    }

    /**
     * 添加首元素
     * @param t
     */
    public void addFirst(T t) {
        add(0,t);
    }

    /**
     * 向数组中插入元素
     * @param index 需要插入的下标
     * @param t 插入的元素
     */
    public void add(int index, T t) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("illegal argments out of range");

        if(size == data.length)
            //数组扩容
            resize(data.length * 2);

        for(int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = t;
        size ++;
    }

    /**
     * 扩容数组
     * @param capacity
     */
    private void resize(int capacity) {
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        this.data = newData;
    }

    /**
     * 获取指定下标元素
     * @param index
     * @return
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get element failed,illegal argments");
        return (T) data[index];
    }

    /**
     * 设置指定下标元素的值
     * @param index
     * @param t
     */
    public void set(int index,T t) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("set element failed,illegal argments");
        data[index] = t;
    }

    /**
     * 删除指定下标的元素
     * @param index
     * @return
     */
    public T delete(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("illegal argments out of range");

        @SuppressWarnings("unchecked")
        T res = (T) data[index];

        for(int i = index; i < size-1; i++)
            data[i] = data[i+1];
        data[size-1] = null;
        size --;
        //缩减数组
        if(size == data.length/2)
            resize(data.length/2);
        return res;
    }

    /**
     * 判断是否包含元素
     * @param t
     * @return
     */
    public boolean contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t)
                return true;
        }
        return false;
    }

    /**
     * 返回元素下标  没有返回-1
     * @param t
     * @return
     */
    public int index(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t)
                return i;
        }
        return -1;
    }

    /**
     * 删除某个元素
     * @param t
     */
    public void deleteElement(T t) {
        int index = index(t);
        if (index != -1)
            delete(index);
    }

    /**
     * 删除第一个元素
     * @return
     */
    public T deleteFirst() {
        return delete(0);
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public T deleteLast() {
        return delete(size - 1);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            if(i == size -1)
                sb.append(data[i]+"]");
            else
                sb.append(data[i]+", ");
        }
        return sb.toString();
    }

}
