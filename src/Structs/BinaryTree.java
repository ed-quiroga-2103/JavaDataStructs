package Structs;

public class BinaryTree {

    public class TreeNode{

        TreeNode(String data){
            this.data = data;
        }

        private TreeNode left;
        private TreeNode right;
        private String data;

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }

        public String getData() {
            return data;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    TreeNode root = null;

    public TreeNode getRoot() {
        return root;
    }

    private boolean strGreaterThan(String a, String b){

        if(a.compareTo(b) < 0){
            return false;
        }
        else if(a.compareTo(b) > 0){
            return true;
        }

        return false;
    }

    public void addNode(String data){

        if(root == null){

            root = new TreeNode(data);

        }
        else{

            TreeNode newNode = new TreeNode(data);
            TreeNode parent = findEmptyNode(data, root);

            if(parent == null){

                System.err.println("Node already exists");
                return;
            }

            if(strGreaterThan(newNode.getData(),parent.getData())){

                parent.setRight(newNode);

            }else{

                parent.setLeft(newNode);

            }

            return;
        }

    }

    public TreeNode findEmptyNode(String data, TreeNode current){

        if(data == current.getData()){

         return null;

        }
        else if(strGreaterThan(data, current.getData()) & current.getRight() == null){

            return current;

        }

        else if(strGreaterThan(current.getData(), data) & current.getLeft() == null){

            return current;

        }
        else if(strGreaterThan(data, current.data)){

            return findEmptyNode(data,current.getRight());

        }
        else {

            return findEmptyNode(data,current.getLeft());

        }


    }

    public TreeNode findNode(String data){

        return findNode_aux(data,root);

    }

    private TreeNode findNode_aux(String data, TreeNode current){


        if(data == current.getData()){

            return current;

        }

        else if(strGreaterThan(data, current.data)){

            return findEmptyNode(data,current.getRight());

        }
        else if(strGreaterThan(current.data, data)){

            return findEmptyNode(data,current.getLeft());

        }
        else {return null;}


    }

}
