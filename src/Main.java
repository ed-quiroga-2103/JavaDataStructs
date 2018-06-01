import Structs.BinaryTree;


public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.addNode("a");

        tree.addNode("b");

        tree.addNode("c");

        tree.addNode("d");

        tree.addNode("e");


        BinaryTree.TreeNode current = tree.getRoot();

        while(current != null){

            System.out.println(current.getData());
            current = current.getRight();

        }

        BinaryTree.TreeNode a = tree.findNode("a");

        System.out.println(a.getData());

    }

}
