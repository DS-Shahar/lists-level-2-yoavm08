import java.util.Scanner;
public class ListsLevel2 {
	Scanner input = new Scanner(System.in);
	public static Scanner reader = new Scanner(System.in);
	
	
	public static Node<Integer> q1(Node<Integer> a, Node<Integer> b) 
	{
	    if (a == null) 
	    	return b;
	    if (b == null) 
	    	return a;

	    Node<Integer> head;
	    if (a.getValue() <= b.getValue()) {
	        head = a;
	        head.setNext(q1(a.getNext(), b));
	    } else {
	        head = b;
	        head.setNext(q1(a, b.getNext()));
	    }
	    return head;
	}
	
	
	public static Node<Integer> q2(Node<Integer> a) {
	    Node<Integer> current = a;
	    while (current != null)
	    {
	        Node<Integer> minNode = current;
	        Node<Integer> iter = current.getNext();
	        while (iter != null)
	        {
	            if (iter.getValue() < minNode.getValue())
	                minNode = iter;
	            iter = iter.getNext();
	        }
	        int temp = current.getValue();
	        current.setValue(minNode.getValue());
	        minNode.setValue(temp);
	        current = current.getNext();
	    }
	    return a;
	}

	
	public static int q3(Node<Integer> a, int value) {
	    int leftDistance = -1, rightDistance = -1, index = 0;
	    Node<Integer> current = a;

	    while (current != null)
	    {
	        if (current.getValue() == value)
	        {
	            if (leftDistance == -1)
	                leftDistance = index;
	            rightDistance = index;
	        }
	        current = current.getNext();
	        index++;
	    }

	    if (leftDistance == -1) 
	        return -1;
	    return rightDistance - leftDistance;

	}
	
	
	public static boolean q4(Node<Integer> a) 
	{
	    Node<Integer> b = a;
	    while (b != null) 
	    {
	        Node<Integer> c = b.getNext();
	        while (c != null) 
	        {
	            if (b.getValue().equals(c.getValue()))
	                return false;
	            c = c.getNext();
	        }
	        b = b.getNext();
	    }
	    return true;
	}
	
	
	public static Node<Integer> q5(Node<Integer> a) 
	{
	    Node<Integer> result = null;
	    Node<Integer> tail = null;
	    while (a != null)
	    {
	    	if (q5_halper(result, a.getValue()) == false)
	        {
	        	Node<Integer> newNode = new Node<>(a.getValue());
	            if (result == null) {
	                result = newNode;
	                tail = newNode;
	            }
	            else {
	                tail.setNext(newNode);
	                tail = newNode;
	            }
	        }
	        a = a.getNext();
	    }
	    return result;
	}

	private static boolean q5_halper(Node<Integer> head, int value) 
	{
	    while (head != null) 
	    {
	        if (head.getValue() == value)
	            return true;
	        head = head.getNext();
	    }
	    return false;
	}



	
	
	
	
	
	
	

}
