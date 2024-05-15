public class ZigZag
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

    public void add(int n)
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
    public void zigZag(Node head)
    {
        if(head == null || head.next == null)
            return;
        
        Node slow = head,fast = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node mid = slow;
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        Node left = head;
        Node right = prev;
        Node nextL,nextR;
        while(left != null && right != null)
        {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            
            left = nextL;
            right = nextR;
        }
    }
    public static void main(String args[])
    {
        ZigZag ll=new ZigZag();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.print(head);
        System.out.println();
        ll.zigZag(head);
        ll.print(head);
    }
}
