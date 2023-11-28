class StackLinkedList{
    private Node head;
    private Node tail;
    private int size;
    class Node{
        private Node next;
        private int val;
        Node(int val){
           this.val=val;
        }    
    }

    public void push(int val){
       Node node =new Node(val);
       size++;
       if(head==null){
          head=node;
          tail=node;
          return;
       }
       tail.next=node;
       tail=node;
    }

    public void pop(){
        if(size==1){
            size--;
            System.out.println("POPED VALUE: "+tail.val);
            head=null;
            tail=null;
            return;
         }
        Node temp=head;
        if(head==null){
           System.out.println("STACK IS EMPTY");
           return;
        }
        while(temp.next!=tail){
           temp=temp.next;
        }
        size--; 
        System.out.println("POPED VALUE: "+tail.val);
        temp.next=null;
        tail=temp;
    }

    private int getSize(){
        return size;
    }

    public int peek(){
        if(head==null){
          System.out.println("STACK IS EMPTY");
          return -1;
        }
        return tail.val;
    }

    public static void main(String args[]){
      StackLinkedList stack=new StackLinkedList();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.pop();
    stack.pop();
    stack.pop();
    System.out.println(stack.peek());
    System.out.println(stack.getSize());
    }
}