public class Remove_Nth_from_end
{
    public class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head,tail;
    public static int size=0;
    public void addFirst(int n)
    {
        Node newNode = new Node(n);
        size++;
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void print(Node head)
    {
        Node temp;
        temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+"----->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public int deleteNthNode(int n)
    {
        int val;
        if(n == size)
        {
            val = head.data;
            head = head.next;
            return val;
        }
        if(n == 0)
        {
            Node prev = head;
            for(int i=0; i<size-2; i++)
                prev=prev.next;
            val = tail.data;
            prev.next=null;
            tail = prev;
            size--;
            return val;
        }
        int del = size-n;
        Node temp = head;
        for(int i = 1 ; i<del; i++)
            temp = temp.next;
        val = temp.next.data;
        temp = temp.next.next;
        return val;
    }
    public static void main(String args[])
    {
        Remove_Nth_from_end ll=new Remove_Nth_from_end();
        ll.addFirst(9);
        ll.addFirst(8);
        ll.addFirst(7);
        ll.addFirst(6);
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print(head);
        System.out.println();
        System.out.println(ll.deleteNthNode(6));
    }
}
