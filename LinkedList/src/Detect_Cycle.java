public class Detect_Cycle
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

    public Boolean detectCycle()
    {
        Node fast = head;
        Node slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Detect_Cycle ll=new Detect_Cycle();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        if(ll.detectCycle())
            System.out.println("It contains cycle");
        else
            System.out.println("It do not contains cycle");
        ll.print(head);

    }
}
