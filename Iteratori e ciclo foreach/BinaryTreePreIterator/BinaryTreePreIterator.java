import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BinaryTreePreIterator implements Iterator<BinaryTreeNode> {
    protected LinkedList<BinaryTreeNode> visiting;

    public BinaryTreePreIterator(BinaryTreeNode root) {
        visiting = new LinkedList<>();
        visiting.addFirst(root);
    }

    @Override
    public boolean hasNext() {
        return (!visiting.isEmpty());
    }

    @Override
    public BinaryTreeNode next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        return preorderNext();
    }

    private BinaryTreeNode preorderNext() {

        BinaryTreeNode node = visiting.getFirst();
        if (node.getRight() != null) {
            visiting.addFirst(node.getRight());
        }
        if (node.getLeft() != null) {
            visiting.addFirst(node.getLeft());
        }

        return node;
    }
}
