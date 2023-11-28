import java.util.LinkedList;
import java.util.Queue;
class BST{
    private Node root;
   
    private class Node{
     private int value;
     private Node left;
     private Node right;
     private int height;
     private Node(int value){
       this.value=value;
     }
    }

    public Node insertInTree(Node curr,int val){
        if(curr==null){
          Node node=new Node(val);
          return node;
        }
        else if(curr.value<val){
        curr.right=insertInTree(curr.right,val);
         }
        else{
          curr.left=insertInTree(curr.left,val);
        }
        return curr;
    }




     public void insert(int val){
         root=insertInTree(root,val);
     }


     public void inOrder(Node root){
        if(root==null){
           return;
        }
        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);
     }

     public void inOrder(){
        inOrder(root);
        System.out.println();
     }

     public void preOrder(Node root){
      if(root==null){
          return;
      }
      System.out.print(root.value+" ");
      preOrder(root.left);
      preOrder(root.right);
     }

     public void preOrder(){
         preOrder(root);
         System.out.println();
     }
    
     public void postOrder(Node root){
      if(root==null){
        return;
    }
    
    preOrder(root.left);
    preOrder(root.right);
    System.out.print(root.value+" ");
     }
     
     public void postOrder(){
      postOrder(root);
      System.out.println();
     }

     public void levelOrder(){
      Queue<Node> q=new LinkedList<Node>();
      q.add(root);
      while(!q.isEmpty()){
       Node temp=q.remove();
       System.out.print(temp.value+" ");
       if(temp.left!=null){
           q.add(temp.left);
       }
       if(temp.right!=null){
            q.add(temp.right);
       }
      }
      System.out.println();
     }


     public Node search(Node root,int value){
     if(root==null){
          System.out.println("NODE NOT FOUND");
          return null;
       }
        else if(root.value==value){
        System.out.println("NODE FOUND IN TREE");
        return root;
      }
      else if(root.value<value){
        return search(root.right,value);
      }
      else{
        return search(root.left,value);
      }
     }
   

     public Node search(int value){
         return search(root,value);
     }
    
     public Node minimum(Node root){
        if(root.left==null){
           return root;
        }
        return minimum(root.left);
     }

     public Node delete(Node root,int value){
     if(root==null){
      System.out.println("NODE NOT FOUND");
      return null;
     }
     else if(root.value>value){
     root.left=delete(root.left,value);
     }
     else if(root.value<value){
      root.right=delete(root.right,value);
     }
     else{
      if(root.left!=null && root.right!=null){
         Node minimum=minimum(root.right);
         root.value=minimum.value;
         delete(root.right,minimum.value);
      }
      else if(root.left!=null){
         root=root.left;
      }
      else if(root.right!=null){
        root=root.right;
        }
       else{
        root=null;
        } 
       }
       return root;
     }

     public void delete(int value){
      delete(root,value);
     }
     
     public int height(Node root){
      if(root==null){
         return 0;
      }
      int left= height(root.left);
      int right=height(root.right);
      return root.height=(Math.max(left,right)+1);
     }

     public int longestDiameter(Node root){
      if(root==null){
        return 0;
      }
      int left=longestDiameter(root.left);
      int right=longestDiameter(root.right);
      int dia=root.left!=null && root.right!=null?root.left.height+root.right.height+1:1;
      return Math.max(dia,Math.max(left,right));
     }
    
     public int longestDiameter(){
      return longestDiameter(root);
     }

     public void printRange(Node root,int x,int y){
     if(root==null){
        return;
     }
     if(root.value>=x && root.value<=y){
     printRange(root.left,x,y);
     System.out.print(root.value+" ");
     printRange(root.right,x,y);
     }
    }

    public static void main(String args[]){
    BST tree=new BST();
    int[]arr={70,50,90,30,60,80,100,20,40,10};
    for(int e : arr){
           tree.insert(e);
    }
      tree.inOrder();
      tree.preOrder();
      tree.postOrder();
      //tree.levelOrder();
    //  tree.search(100);
     // tree.delete(20);
     // tree.levelOrder();
    //  tree.height(tree.root);
    //  System.out.println(tree.longestDiameter());
    //System.out.println(tree.root.left.left.left.left.left.height);
    //tree.printRange(tree.root,30,100);
    }
}