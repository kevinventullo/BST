import java.util.Stack;
public class BST{
    
    Node root;
    
    public static class Node{
        Node left;
        Node right;
        int key;
        
        public Node(int x){
            key = x;
            left = null;
            right = null;
        }
    }
    
    public static boolean isBST(Node root){
        if(root==null) return true;
        Stack<Node> nstack = new Stack<Node>();
        Node curr = root;
        
        while(curr.left!=null){
            nstack.push(curr);
            curr=curr.left;
        }
        int prev = Integer.MIN_VALUE;
        while(curr!=null){
            if(prev > curr.key) return false;
            prev = curr.key;
            curr=iterate(nstack, curr);
        }
        return true;
    }
    
    public static Node iterate(Stack<Node> nstack, Node curr){
        //curr is not on the stack, but all its parents are
        if(curr.right!=null){
            nstack.push(curr);
            curr=curr.right;
            while(curr.left!=null){
                nstack.push(curr);
                curr=curr.left;
            }
            return curr;
        }
        else{
            if(nstack.isEmpty()){
                curr = null;
                return curr;
            }
            while(curr==nstack.peek().right){
                curr=nstack.pop();
                if(nstack.isEmpty()){
                    curr=null;
                    return curr;
                }
            }
            curr=nstack.pop();
            return curr;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void add(int x){
        Node newnode = new Node(x);
        if(root==null){
            root = newnode;
            return;
        }
        Node parent = root;
        Node child;
        if(x < parent.key) child = parent.left;
        else child = parent.right;
        while(child!=null){
            System.out.println("c");
            if(x< child.key){
                parent=child;
                child=child.left;
            }
            else{
                parent=child;
                child=child.right;
            }
        }
        child = newnode;
    }
    
    public static void main(String[] args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        
        n2.left=n1;
        n2.right=n3;
        System.out.println(isBST(n1));
        
    }
    
    
    
}