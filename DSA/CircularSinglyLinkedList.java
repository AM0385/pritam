class CircularSinglyLinkedList{
    private Node head;
    private Node tail;
    private int size;
   
    private class Node{
     private int val;
     private Node next;
     private Node(int val){
       this.val=val;
     }
     private Node(int val,Node next){
        this.val=val;
        this.next=next;
      }
    }

    public void addFirst(int val){
      Node node=new Node(val);
      size++;
      if(head==null){
        head=node;
        tail=head;
        head.next=head;
        return;
      }
      node.next=head;
      head=node;
    }

    public void addLast(int val){
      Node node=new Node(val);
        if(head==null){
         addFirst(val);
         return;
       }
       size++;
       tail.next=node;
       tail=node;
       tail.next=head;
      
    }
   
    public void print(){
        Node temp=head;
        do{
          System.out.print(temp.val+"->");
           temp=temp.next;
         
        }while(temp!=head);
        System.out.println("HEAD");
    }

    public void deleteFirst(){
     head=head.next;
     tail.next=head;
    }

    public void deleteLast(){
        Node temp=head;
        while(temp.next.next!=head){
            temp=temp.next;
        }
        tail=temp;
        tail.next=head;
    }

    public static void main(String args[]){
    CircularSinglyLinkedList list=new CircularSinglyLinkedList();
     list.addFirst(5); 
     list.addFirst(10);
     list.addFirst(1);
     list.addLast(20);
     list.addLast(30);
     list.addLast(40);
     list.addLast(50);
     list.print();
     list.deleteFirst();
     list.deleteLast();
     list.print();
    }
}