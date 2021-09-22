public class BinaryTreeNode {
    private Object value;
    private BinaryTreeNode left, right;

    public BinaryTreeNode(Object value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }
}
