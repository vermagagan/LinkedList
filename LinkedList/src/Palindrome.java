public class Palindrome
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
    public void addFirst(int n)
    {
        Node newNode = new Node(n);
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public Node findMid(Node head)
    {
        Node slow=head, fast=head;
        while(fast != null && fast.next != null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public Boolean checkPalindrome()
    {
        if(head == null || head.next == null)
            return true;

        //find mid node
        Node mid = findMid(head);

        //Reverse 2nd Half
        Node curr = mid;
        Node prev = null;
        Node next;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while(right != null)
        {
            if(left.data != right.data)
                return false;
            
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String args[])
    {
        Palindrome ll=new Palindrome();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(0);
        if(ll.checkPalindrome())
            System.out.println("LL is Palindrome");
        else
            System.out.println("LL is not Palindrome");
        
    }
}
