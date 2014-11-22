public class LinkedListElement 
{
	LinkedListElement previous;
	Object element;
	LinkedListElement next;
	
	LinkedListElement(Object obj)
	{
		previous = null;
		element = obj;
		next = null;
	}
	
	LinkedListElement(LinkedListElement prev, Object obj, LinkedListElement nxt)
	{
		previous = prev;
		element = obj;
		next = nxt;
	}
}
