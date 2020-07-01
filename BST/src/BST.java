import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树
 *
 * @author Y
 * @since 2020/6/30
 */
public class BST<T extends Comparable<T>> {

    // 节点
    private class Node {
        private T data;
        private Node left, right;

        // 默认构造函数
        public Node(T data) {
            this.data = data;
        }
    }


    private Node root;
    private int size;

    // 构造函数 可以不写
    public BST() {
        root = null;
        size = 0;
    }

    /**
     * 获取二叉树中的元素个数
     * @return 返回元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断二分搜索树是否为空
     * @return T OR F
     */
    public boolean isEmpty() {
        return size == 0;
    }



    /**
     * 向二分搜索树种添加元素
     * @param data 添加的元素
     */
    public void add(T data) {
        // 这边首先要判断下root节点是否为空
        if (root == null) {
            size ++;
            root = new Node(data);
        } else {
            add(root, data);
        }
    }

    /**
     * 辅助函数 向指定根节点node中添加元素
     * @param node 插入元素的根节点
     * @param data 插入的元素
     */
    private void add(Node node, T data) {
        if (data.compareTo(node.data) == 0) {
            // 如果相等 直接返回
            return;
        } else if (data.compareTo(node.data) < 0 && node.left == null) {
            // 添加的元素比根节点元素小 并且根节店没有左孩子
            // 将新增的节点挂接到原来的节点上
            node.left = new Node(data);
            size ++;
            return;
        } else if (data.compareTo(node.data) > 0 && node.right == null) {
            // 添加的元素比根节点元素大 并且根节点没有右孩子
            node.right = new Node(data);
            size ++;
            return;
        } else if (data.compareTo(node.data) < 0) {
            // 剩下的情况 添加的元素比根节点小 但是根节点有左孩子 这边就使用递归 往根节点的左子树再添加元素
            add(node.left, data);
        } else {
            add(node.right, data);
        }
    }


    /**
     * 添加元素
     * @param data 指定添加的元素
     */
    public void add_upgrade(T data) {
        root = add_upgrade(root, data);
    }

    /**
     * 升级方法 会返回添加之后的元素节点
     * @param node 指定根节点
     * @param data 指定元素
     */
    private Node add_upgrade(Node node, T data) {
        if (node == null) {
            return new Node(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = add_upgrade(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = add_upgrade(node.right, data);
        }
        return node;
    }

    /**
     * 查找指定元素的节点
     * @param data 指定元素
     * @return 返回指定元素的节点
     */
    public Node get(T data) {
        return get(root, data);
    }

    /**
     * 辅助函数 在指定根节点查找元素
     * @param node 指定的根节点
     * @param data 查找的元素
     * @return 返回指定元素的节点
     */
    private Node get(Node node, T data) {
        // 如果节点为null  直接抛出异常
        if (node == null) {
            throw new RuntimeException("not exist element "+ data);
        }
        // 如果节点值相等 返回当前节点
        if (data.compareTo(node.data) == 0) {
            return node;
        } else if (data.compareTo(node.data) < 0 ) {
            // 之后递归遍历左右子树
            return get(node.left, data);
        } else {
            return get(node.right, data);
        }
    }

    /**
     * 判断是否包含元素
     * @param data 指定元素
     * @return 包含或者不包含
     */
    public boolean contains(T data) {
        return contains(root, data);
    }

    /**
     * 辅助函数 判断当前根节点下是否包含指定元素
     * @param node 当前根节点
     * @param data 指定元素
     * @return T OR F
     */
    private boolean contains(Node node, T data) {
        if (node == null) {
            return false;
        } else if (data.compareTo(node.data) == 0) {
            return true;
        } else if (data.compareTo(node.data) < 0) {
            return contains(node.left, data);
        } else {
            return contains(node.right, data);
        }
    }


    /**
     * 前序遍历
     */
    public void preTraverse() {
        preTraverse(root);
    }

    /**
     * 前序遍历根节点是node的子树
     * @param node 根节点
     */
    private void preTraverse(Node node) {
        if (node == null)
            return;

        System.out.println(node.data);
        preTraverse(node.left);
        preTraverse(node.right);
    }

    /**
     * 中序遍历  遍历出来是排序的  从小到大输出
     */
    public void midTraverse() {
        midTraverse(root);
    }


    /**
     * 中序遍历
     * @param node 根节点
     */
    private void midTraverse(Node node) {
        if (node == null)
            return;
        midTraverse(node.left);
        System.out.println(node.data);
        midTraverse(node.right);
    }

    /**
     * 后续遍历
     */
    public void subsequentTraversal() {
        subsequentTraversal(root);
    }

    /**
     * 后续遍历
     * @param node 根节点
     */
    private void subsequentTraversal(Node node) {
        if (node == null)
            return;
        subsequentTraversal(node.left);
        subsequentTraversal(node.right);
        System.out.println(node.data);
    }

    /**
     * 迭代实现二分搜索树的前序遍历
     * 使用栈结构模拟
     */
    public void preTraverseIterate() {
        Stack<Node> stack = new Stack<>();
        // 首先添加根节点元素
        stack.push(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.data);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 迭代实现二分搜索树的广度优先遍历
     * 借助队列数据结构模拟
     */
    public void breadthTraversal() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.data);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }
    }


}
