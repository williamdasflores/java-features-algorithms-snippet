package data_structure.binary_serch_tree;

import lombok.Data;


@Data
public class Node {

    private Integer root;
    private Node right;
    private Node left;

    public Node(Integer root) {
        this.root = root;
    }


}
