import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class GraphList{
     ArrayList<Node> list;
     
     public static class Node{
        String data;
        int index;
        boolean isVisited;
        ArrayList<Node> neighbour=new ArrayList<Node>();
        
        public Node(int index,String data){
         this.index=index;
         this.data=data;
        } 
     }

     public GraphList(ArrayList<Node>list){
        this.list=list;
       }
    
    public void addEdge(int i , int j){
       Node first=list.get(i);
       Node second=list.get(j);
       first.neighbour.add(second);
       second.neighbour.add(first);
    }

    public void print(){
        for(Node ele : list){
            System.out.print(ele.data+" ");
          for(Node data : ele.neighbour){
             System.out.print(data.data+" ");
          }
          System.out.println();
        }
    }
  
    public void bfs(){
      Queue<Node>q=new LinkedList<Node>();
      q.add(list.get(0));
      while(!q.isEmpty()){
       Node temp=q.remove();
       temp.isVisited=true;
       System.out.print(temp.data+" ");
       for(Node ele : temp.neighbour){
           if(!ele.isVisited){
             q.add(ele);
             ele.isVisited=true;
           }
        }
      }
    }


    public void dfs(){
      Stack<Node> stack=new Stack<Node>();
      stack.push(list.get(0));
      while(!stack.isEmpty()){
        Node temp=stack.pop();
        temp.isVisited=true;
        System.out.print(temp.data+" ");
        for(Node node : temp.neighbour){
             if(!node.isVisited){
                 stack.push(node);
                 node.isVisited=true;
             }
        }
      }
    }
    
    public static void main(String[] args) {
    ArrayList<Node>list=new ArrayList<>();
    list.add(new Node(0,"A"));
     list.add(new Node(1,"B"));
     list.add(new Node(2,"C"));
     list.add(new Node(3,"D"));
     list.add(new Node(4,"E"));
     GraphList graph=new GraphList(list);
     graph.addEdge(0,1);
     graph.addEdge(0,2);
     graph.addEdge(0,3);
     graph.addEdge(1,4);
     graph.addEdge(2,3);
     graph.addEdge(3,4);
     //graph.print();
    //graph.bfs();
    graph.dfs();
    }
}