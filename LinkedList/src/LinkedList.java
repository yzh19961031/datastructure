/**
 * 单向链表
 * @author Y
 * @date 2020/5/27
 */
public class LinkedList<T> {
    private Node head;

    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    private class Node {
        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node (T data) {
            this(data,null);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    // 添加指定位置
    public void add(int index, T data) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("illegal param");
        // 找到前一个节点位置
        if (index == 0) {
            head = new Node(data,head);
            size++;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node newNode = new Node(data,prev.next);
            prev.next = newNode;
            size++;
        }
    }

    // 添加最后一个元素
    public void addLast(T data) {
        add(size,data);
    }

    // 添加第一个元素
    public void addFirst(T data) {
        add(0,data);
    }

    // 删除指定下标元素
    public T delete(int index) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("illegal param");
        // 找到前一个元素
        T res;
        if (index == 0) {
            res = head.data;
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            res = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return res;
    }

    public T deleteFirst() {
        return delete(0);
    }

    public T deleteLast() {
        return delete(size - 1);
    }

    // 查询
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal param");
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public T getLast() {
        return get(size - 1);
    }

    public T getFirst() {
        return get(0);
    }

    // 设置指定下标元素的值
    public T set(int index, T data) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal param");
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        T res = cur.data;
        cur.data = data;
        return res;
    }

    // 判断是否包含
    public boolean contains(T data) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (data.equals(cur.data))
                return true;
        }
        return false;
    }


    @Override
    public String toString() {
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList ");
        while (cur != null) {
            sb.append(cur.data+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        System.out.println(linkedList.size);
        linkedList.add(2,88);
        System.out.println(linkedList);
        System.out.println(linkedList.delete(3));
        System.out.println(linkedList);
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.set(2,99));
        System.out.println(linkedList);
        System.out.println(linkedList.contains(99));
        System.out.println(linkedList.contains(88));
    }

}
