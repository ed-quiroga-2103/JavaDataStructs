package Structs;

/*
 *  Java Program to Implement AVL Tree
 */

import java.util.Scanner;


/* Class AVLTree */
public class AVLTree
{
    /* Class AVLNode */
    public class AVLNode
    {
        AVLNode left, right;
        public String data;
        int height;

        /* Constructor */
        public AVLNode()
        {
            left = null;
            right = null;
            data = null;
            height = 0;
        }
        /* Constructor */
        public AVLNode(String n)
        {
            left = null;
            right = null;
            data = n;
            height = 0;
        }
    }


    private AVLNode root;

    /* Constructor */
    public AVLTree()
    {
        root = null;
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

    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return root == null;
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        root = null;
    }
    /* Function to insert data */
    public void insert(String data)
    {
        root = insert(data, root);
    }
    /* Function to get height of node */
    private int height(AVLNode t )
    {
        return t == null ? -1 : t.height;
    }
    /* Function to max of left/right node */
    private int max(int lhs, int rhs)
    {
        return lhs > rhs ? lhs : rhs;
    }
    /* Function to insert data recursively */
    private AVLNode insert(String x, AVLNode t)
    {
        if (t == null)
            t = new AVLNode(x);
        else if (strGreaterThan(t.data, x))
        {
            t.left = insert( x, t.left );
            if( height( t.left ) - height( t.right ) == 2 )
                if( strGreaterThan(t.left.data,x) )
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if( strGreaterThan(x, t.data) )
        {
            t.right = insert( x, t.right );
            if( height( t.right ) - height( t.left ) == 2 )
                if( strGreaterThan(x,t.right.data))
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        else
            ;  // Duplicate; do nothing
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    /* Rotate binary tree node with left child */
    private AVLNode rotateWithLeftChild(AVLNode k2)
    {
        AVLNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    private AVLNode rotateWithRightChild(AVLNode k1)
    {
        AVLNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child */
    private AVLNode doubleWithLeftChild(AVLNode k3)
    {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child */
    private AVLNode doubleWithRightChild(AVLNode k1)
    {
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(root);
    }
    private int countNodes(AVLNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public AVLNode search(String val)
    {
        return search(root, val);
    }
    private AVLNode search(AVLNode r, String val)
    {
        AVLNode node = null;
        boolean found = false;
        while ((r != null) && !found)
        {
            String rval = r.data;
            if (strGreaterThan(rval,val))
                r = r.left;
            else if (strGreaterThan(val,rval))
                r = r.right;
            else
            {
                node = r;
                found = true;
                break;
            }
        }
        return node;
    }
    /* Function for inorder traversal */
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(AVLNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(AVLNode r)
    {
        if (r != null)
        {
            System.out.print(r.data +" ");
            preorder(r.left);
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(AVLNode r)
    {
        if (r != null)
        {
            postorder(r.left);
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }
}


