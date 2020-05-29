import java.util.NoSuchElementException;

/**
 * 双向链表
 * @author Y
 * @date 2020/5/29
 */
public class DoubleSideLinkedList<T> {
    private Node first;
    private Node last;
    private int size;

    // 默认构造函数
    public DoubleSideLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    private class Node {
        private T data;
        private Node prev,next;

        public Node(Node prev, T data,Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

        public Node() {
        }

        public Node(T data) {
            this.data = data;
        }
    }

    // 判断当前链表是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    // 获得当前链表元素个数
    public int getSize() {
        return this.size;
    }

    public void add(int index,T data) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("illegal param");

        if (size == index) {
            linkLast(data);
        } else {
            linkBefore(data,node(index));
        }
    }

    // 添加第一个元素
    public void addFirst(T data) {
        linkFirst(data);
    }

    // 添加最后一个元素
    public void addLast(T data) {
        linkLast(data);
    }

    // 移除指定索引元素
    public T remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal param");
        return unLink(node(index));
    }

    public T removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return remove(0);
    }

    public T removeLast() {
        if (last == null)
            throw new NoSuchElementException();
        return remove(size - 1);
    }

    // 判断是否包含元素
    public boolean contains(T data) {
        for (Node cur = first; cur != null; cur = cur.next) {
            if (data.equals(cur.data)) {
                return true;
            }
        }
        return false;
    }

    // 设置索引位置元素值
    public T set(int index, T data) {
        Node node = node(index);
        T res = node.data;
        node.data = data;
        return res;
    }

    // 移除目标节点
    private T unLink(Node node) {
        T res = node.data;
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null; // help GC
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null; // help GC
        }
        node.data = null;
        size--;
        return res;
    }

    /**
     * 在指定节点之前插入节点
     * @param data 需要添加的节点元素
     * @param node 指定的节点
     */
    private void linkBefore(T data, Node node) {
        // 新增节点的前一个节点指向当前节点的前一个节点
        // 下一个节点指向当前的节点
        Node prev = node.prev;
        Node newNode = new Node(prev,data,node);

        node.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    // 挂接最后一个元素
    private void linkLast(T data) {
        Node l = last;
        Node newNode = new Node(l,data,null);
        last = newNode;
        // 如果链表为空 就把头结点也赋值成新增节点
        if (l == null) {
            first = newNode;
        } else {
            // 否则就将之前尾结点的next引用指向新增节点
            l.next = newNode;
        }
        size++;
    }

    // 挂接第一个元素
    private void linkFirst(T data) {
        Node f = first;
        Node newNode = new Node(null,data,f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    /**
     * 辅助函数 根据索引位置找到对应节点
     * @param index 索引位置
     * @return 返回对应节点
     */
    private Node node(int index) {
        // 参考LinkedList原码 遍历找到对应索引的节点
        if (index < (size >> 1)) {
            Node x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node x = last;
            // 从后往前遍历
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleSideLinkedList ");
        for (Node cur = first; cur != null; cur = cur.next) {
            sb.append(cur.data + "->");
        }
        sb.append("NULL");
        return sb.toString();
    }


//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("DoubleSideLinkedList ");
//        for (Node cur = last; cur != null; cur = cur.prev) {
//            sb.append(cur.data + "->");
//        }
//        sb.append("NULL");
//        return sb.toString();
//    }

    public static void main(String[] args) {
        DoubleSideLinkedList<Integer> linkedList = new DoubleSideLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.linkLast(i);
        }
        System.out.println(linkedList);
        System.out.println(linkedList.remove(3));
        System.out.println(linkedList);
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.contains(4));
        linkedList.set(3,999);
        System.out.println(linkedList);
    }


}
