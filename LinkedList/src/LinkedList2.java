/**
 * 带有虚拟头结点的链表 会浪费一个空间
 * @author Y
 * @date 2020/5/27
 */
public class LinkedList2<T> {
    private Node dummyNode;
    private int size;

    public LinkedList2() {
        this.dummyNode = new Node();
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

        public Node() {

        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("illegal param");
        Node prev = dummyNode;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node newNode = new Node(data,prev.next);
        prev.next = newNode;
        size++;
    }

    // 添加最后一个元素
    public void addLast(T data) {
        add(size,data);
    }

    // 添加第一个元素
    public void addFirst(T data) {
        add(0,data);
    }

    public T delete(int index) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("illegal param");
        Node prev = dummyNode;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        T res = prev.next.data;
        prev.next = prev.next.next;
        //prev.next.next = null;
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
        Node cur = dummyNode.next;
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
        Node cur = dummyNode.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        T res = cur.data;
        cur.data = data;
        return res;
    }

    // 判断是否包含
    public boolean contains(T data) {
        for (Node cur = dummyNode.next; cur != null; cur = cur.next) {
            if (data.equals(cur.data))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Node cur = dummyNode.next;
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
        LinkedList2<Integer> linkedList = new LinkedList2<>();
        for (int i = 0; i < 10; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
        System.out.println(linkedList.getSize());
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
