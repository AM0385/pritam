class SinglyLinkedList{
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        int val;
        Node next;
        Node(int n){
         this.val=n;
        }
        Node(int n,Node next){
            this.val=n;
            this.next=next;
           }
    }
    public void addFirst(int n){
      Node node=new Node(n);
      if(head==null){
         head=node;
         tail=node;
         size=1;
         return;
      }  
      node.next=head;
      head=node;
      size++;
    }

    public void addLast(int n){
     Node node=new Node(n);
     if(head==null){
          addFirst(n);
     }
     tail.next=node;
      tail=node;
      size++;
    }

    public void print(){
       Node temp=head;
       if(temp==null){
          System.out.println("LIST IS EMPTY");
          return;
       }
       while(temp!=null){
         System.out.print(temp.val+" ");
         temp=temp.next;
       }
       System.out.println();
    }

    public int size(){
        return size;
    }

    public void reverse(){
        Node first=head;
        Node second=head.next;
        while(second.next!=null){
           Node third=second.next;
           second.next=first;
           first=second;
           second=third;
        }
        second.next=first;
        head.next=null;
         tail=head;
        head=second;
    }
    
    public void last(int n){
        Node node=new Node(n);
        Node temp=head;
        while(temp.next!=null){
           temp=temp.next;
        }
        temp.next=node;
        tail=node;
        size++;
    }
   
    public boolean searchByValue(int val){
        Node temp=head;
        while(temp!=null){
          if(temp.val==val){
              System.out.println("NODE FOUND");
              return true;
          }
          temp=temp.next;
        }
        System.out.println("NODE NOT FOUND");
        return false;
    }

    public void insertAt(int index,int val){
        Node temp=head;
        Node node=new Node(val);
        int i=1;
        while(i<index){
           temp=temp.next;
           i++;
        }
        node.next=temp.next;
        temp.next=node;
        size++;
    }


   public void deleteFirst(){
      size--;
      head=head.next;
   }

   public void deleteLast(){
    Node temp=head;
    while(temp.next!=tail){
        temp=temp.next;
    }
    size--;
    temp.next=null;
     tail=temp; 
  }
  
  public void deleteAll(){
    head=null;
    tail=null;
    size=0;
    System.out.println("DELETED LINKEDLIST");
  }

  public void deleteByIndex(int index){
   if(index==0){
    deleteFirst();
    return;
   }
   if(index>=size){
      deleteLast();
      return;
   }
   Node temp=head;
   int i=1;
   while(i<index){
      temp=temp.next;
      i++;
   }
   temp.next=temp.next.next;
   size--;
  }

  public void deleteNthFromBack(int n){
   int position =size-n;
   if(position==0){
      deleteFirst();
      return;
   }
   if(position==size-1){
    deleteLast();
    return;
   }
   Node temp=head;
   int i=1;
   while(i<position){
    temp=temp.next;
    i++;
   }
   size--;
   temp.next=temp.next.next;
  }

  public String printData(){
    Node temp=head;
    String str="";
    while(temp!=null){
      str+=temp.val;
      temp=temp.next;
    }
    return str;
  }

  public boolean checkPalindrome(){
    String str=printData();
    reverse();
    String str2=printData();
    if(str.equals(str2)){
      System.out.println("YES IT IS PALIN");
        return true;
    }
    System.out.println("NO IT IS NOT PALIN");
    return false;
    
  }

  public void makeCycle(){
    int i=0;
    Node temp=head;
    while(i<=2){
       temp=temp.next;
       i++;
    }
      tail.next=temp;
  }
  public int detectCycle() {
    Node fast = head;
    Node slow = head;

    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (slow == fast){ 
        int count = 0;
        Node temp = slow;
        do {
            temp = temp.next;
            count++;
        } while (temp != slow);
    
         return count; 
        }
    }
       return 0;
    }

   public void findMiddleNode(){
      Node slow=head;
      Node fast=head;
   while(fast.next!=null){
     
      if(fast.next.next==null){
          break;
      }
      slow=slow.next;
      fast=fast.next.next;
   }
   System.out.println("MIDDLE OF LIST VALUE IS :"+slow.val);
   }

    public static void main(String args[]){
     SinglyLinkedList list=new SinglyLinkedList();
     list.addFirst(1);
     list.addFirst(2);
     list.addFirst(8);
     list.addFirst(4);
     list.addLast(0);
     list.addLast(2);
      list.last(5);
    //  list.last(15);
     list.insertAt(3,10);
     //list.deleteNthFromBack(1);
     //list.deleteFirst();
     //list.deleteLast();
    // list.deleteByIndex(2);
    //list.makeCycle();
    //System.out.print(list.detectCycle());
    list.print();
    list.findMiddleNode();
    // list.checkPalindrome();
     //list.reverse();
     //list.print();
     //list.searchByValue(4);
    //list.deleteAll();
    //list.print();
     //System.out.println(list.size());


    }

}