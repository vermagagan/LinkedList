public class Basics
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
    public static int size;

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

    public void addLast(int n)
    {
        Node newNode = new Node(n);
        size++;
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        newNode.next = null;
    }

    public void add_at_idx(int data, int idx)
    {
        if(idx == 0)
        {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        int i=0;
        Node temp=head;
        while(i < idx-1)
        {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public int removeFirst()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            size = 0;
            int val = head.data;
            head = head.next;
            return val;
        }
        size --;
        int val = head.data;
        head = head.next;
        return val;
    }
    public int removeLast()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            size = 0;
            int val = tail.data;
            tail = tail.next;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++)
            prev=prev.next;
        int val = tail.data;
        prev.next=null;
        tail = prev;
        size--;
        return val;

    }
    public int Search(int key)
    {
        Node temp=head;
        int i=0;
        while(temp != null)
        {
            if(temp.data == key)
                return i;
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int searchRecur(int key, Node head)
    {
        if(head == null)
            return -1;
        if(head.data == key)
            return 0;
        int idx = searchRecur(key, head.next);
        if(idx == -1)
            return -1;
        return idx+1;
    }
    public void reverse()
    {
        Node prev =  null;
        Node curr = tail = head;
        Node next;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String args[])
    {
        Basics ll = new Basics();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.print(head);
        System.out.println();
        ll.add_at_idx(4, 3);
        ll.print(head);
        System.out.println();
        System.out.println("Size of LinkedList is: "+size);
        System.out.println(ll.removeFirst());
        ll.print(head);
        System.out.println();
        System.out.println(ll.removeLast());
        ll.print(head);
        System.out.println();
        System.out.println("Number found at: "+ll.Search(5));
        System.out.println("Number found at: "+ll.Search(5));
        ll.reverse();
        ll.print(head);
    }
}
