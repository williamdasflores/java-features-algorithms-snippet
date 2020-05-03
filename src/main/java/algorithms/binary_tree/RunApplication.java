package algorithms.binary_tree;

public class RunApplication {

    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        myTree.insert(13);
        myTree.insert(15);
        myTree.insert(30);
        myTree.insert(25);

        myTree.insert(10);
        myTree.insert(11);
        myTree.insert(8);
        myTree.insert(29);
        myTree.insert(14);
        myTree.insert(16);
        myTree.insert(35);
        myTree.insert(2);

        System.out.println(myTree.print(myTree.getRoot()));
        System.out.println("Min Value: " + myTree.getMinNode(myTree.getRoot()));
        System.out.println("Max Value: " + myTree.getMaxNode(myTree.getRoot()));
    }
}
