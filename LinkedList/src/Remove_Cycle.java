public class Remove_Cycle
{
    public static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public void removeCycle()
    {
        //Detect
        Node fast = head, slow = head;
        Boolean cycle = false;
        while(fast != null || fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
            {
                cycle = true;
                break;
            }
        }

        if(cycle == false)
            return;
        
        slow = head;
        Node prev = null;
        while(slow != fast)
        {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
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

    public static void main(String args[])
    {
        Remove_Cycle ll=new Remove_Cycle();
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        ll.removeCycle();
        ll.print(head);
    }
}
