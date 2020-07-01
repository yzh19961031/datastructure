/**
 * @author Y
 * @since 2020/7/1
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(25);
        bst.add(23);
        bst.add(22);
        bst.add(24);
        bst.add(29);
        bst.add(28);
        bst.add(31);

        System.out.println(bst.getSize());
        System.out.println(bst.isEmpty());

        System.out.println(bst.contains(22));
        System.out.println(bst.contains(52));

        bst.preTraverse();
        System.out.println();
        bst.preTraverseIterate();
        System.out.println();
        bst.midTraverse();
        System.out.println();
        bst.subsequentTraversal();
        System.out.println();
        bst.breadthTraversal();
    }
}
