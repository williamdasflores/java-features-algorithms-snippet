package data_structure.binary_serch_tree;

public class BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void insert(Integer value) {
        Node node = new Node(value);

        if (root == null)
            root = node;
        else
            insertNode(root, node);
    }

    private void insertNode(Node currentNode, Node newNode) {
        if (currentNode.getRoot() > newNode.getRoot()) {
            if (currentNode.getLeft() == null)
                currentNode.setLeft(newNode);
            else
                insertNode(currentNode.getLeft(), newNode);
        } else {
            if (currentNode.getRight() == null)
                currentNode.setRight(newNode);
            else
                insertNode(currentNode.getRight(), newNode);
        }
    }

    private void traversePreorder(StringBuilder sb, String padding, String pointer, Node node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getRoot());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("|  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "R: ";
            String pointerForLeft = "L: ";

            traversePreorder(sb, paddingForBoth, pointerForLeft, node.getLeft());
            traversePreorder(sb, paddingForBoth, pointerForRight, node.getRight());
        }
    }

    public Integer getMinNode(Node node) {
        if (node.getLeft() != null)
            return getMinNode(node.getLeft());
        else
            return node.getRoot();
    }

    public Integer getMaxNode(Node node) {
        if (node.getRight() != null)
            return getMaxNode(node.getRight());
        else
            return node.getRoot();
    }

    public String print(Node node) {
        StringBuilder str = new StringBuilder();
        traversePreorder(str, "", "", node);
        return str.toString();
    }
}
