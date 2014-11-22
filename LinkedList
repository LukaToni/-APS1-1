
public class LinkedList
{
	protected LinkedListElement first;
	protected LinkedListElement last;
	
	LinkedList()
	{
		makenull();
	}
	
	//Funkcija makenull inicializira seznam
	public void makenull()
	{
		//drzimo se implementacije iz knjige:
		//po dogovoru je na zacetku glava seznama (header)
		first = new LinkedListElement(null, null, null);
		last = null;
	}
	
	//Funkcija addLast doda nov element na konec seznama
	public void addLast(Object obj)
	{
		//najprej naredimo nov element
		LinkedListElement node =  new LinkedListElement(null,obj, null);
		//ustrezno ga povezemo s koncem verige obstojecih elementov
		
		//po potrebi posodobimo kazalca "first" in "last"
		if(last == null)
		{
			node.previous = first;
			//node.next = null; // imamo ze nastavljeno
			first.next  = node;
			last = first.next;
		}
		else 
		{
			node.previous = last;
			//node.next = null; imamo ze nastavljeno
			last.next = node;
			last = last.next;
		}
	}
	

	
	
	//Funkcija write izpise elemente seznama
	public void write()
	{
		//zacnemo pri elementu za glavo seznama
		//sprehodimo se po elementih do konca seznama
		//in izpisemo vrednost vsakega elementa
		LinkedListElement tmp = first.next;
		while (tmp != null)
		{
			if(tmp.next == null)
			{
				System.out.print(tmp.element + ".");
				break;
			}
			System.out.print(tmp.element + ", ");
			tmp = tmp.next;
		}
		//za kontrolo lahko izpisemo tudi vrednosti kazalcev "first" in "last"
		System.out.println();
		System.out.println("first = " + first.next.element);
		System.out.println("last = " + last.element);
	}
	
	public void writeRek()
	{
		//zacnemo pri elementu za koncu seznama
		//sprehodimo se po elementih do zacetka seznama
		//in izpisemo vrednost vsakega elementa
		LinkedListElement tmp = last;
		while (tmp  != null)
		{
			if(tmp.previous == first)
			{
				System.out.print(tmp.element + ".");
				break;
			}
			System.out.print(tmp.element + ",  ");
			tmp  = tmp.previous;
		}
		//za kontrolo lahko izpisemo tudi vrednosti kazalcev "first" in "last"
		System.out.println();
		System.out.println("first = " + first.next.element);
		System.out.println("last = " + last.element);
	}
	
	
	//Funkcija addFirst doda nov element na prvo mesto v seznamu (takoj za glavo seznama)
	void addFirst(Object obj)
	{
		//najprej naredimo nov element
		LinkedListElement node =  new LinkedListElement(obj);
		//ustrezno ga povezemo z glavo seznama
		//po potrebi posodobimo kazalca "first" in "last"
		if( first.next == null )
		{
			first.next = node;
			last = node;
			node.previous = first;
			
		}
		else
		{
			first.next.previous = node;
			node.next = first.next;
			first.next = node;
			node.previous = first;
		}
	}
	
	//Funkcija length() vrne dolzino seznama (pri tem ne uposteva glave seznama)
	int length()
	{
		int count = 0;
		LinkedListElement tmp = first;
		while(tmp.next != null)
		{
			count++;
			tmp = tmp.next;
		}
		return count;
	}
	
	//Funkcija lengthRek() klice rekurzivno funkcijo za izracun dolzine seznama
	int lengthRek()
	{
		// pomagajte si z dodatno funkcijo int lengthRek(LinkedListElement el), ki izracuna
		// dolzino seznama za opazovanim elementom ter pristeje 1
		return lengthRek(first);
	}
	
	int lengthRek(LinkedListElement el)
	{
		if (el.next != null)
			return lengthRek( el.next) + 1;
		return 0;
	}
	
	//Funkcija insertNth vstavi element na n-to mesto v seznamu
	//(prvi element seznama, ki se nahaja takoj za glavo seznama, je na indeksu 0)
	boolean insertNth(Object obj, int n)
	{

		//zacnemo pri glavi seznama
		LinkedListElement tmp = first;
		//sprehodimo se po elementih dokler ne pridemo do zeljenega mesta

		if ( n == 1)
		{
			addFirst(obj);
			return true;
		}
		
		if ( n == length() +1 )
		{
			addLast(obj);
			return true;
		}
		if (n > 1 && n < length() +1)
		{
			while(tmp.next != null && n > 1)
			{
				n--;
				tmp = tmp.next;
			}
	
			// ce je polozaj veljaven
			if( tmp != null)
			{
				//   naredimo nov element
				LinkedListElement node =   new LinkedListElement(obj);
				//   ustrezno ga povezemo v verigo elementov
				node.next = tmp.next;
				tmp.next = node;
				node.previous = tmp;
				tmp.next.next.previous = node;
				//   po potrebi posodobimo kazalec "last"
				if(node.next == null)
					last = node;
				//   vrnemo true
				return true;
			}
		}

		return false;
		
	}
	
	//Funkcija deleteNth izbrise element na n-tem mestu v seznamu
	//(prvi element seznama, ki se nahaja takoj za glavo seznama, je na indeksu 0)
	boolean deleteNth(int n)
	{
		//zacnemo pri glavi seznama
		LinkedListElement el;
		LinkedListElement prev;
		//sprehodimo se po elementih dokler ne pridemo do zeljenega mesta
		prev = null;
		el = first;
		// ce je polozaj veljaven
		for(int i = 0; i < n ; i++)
		{
			prev = el;
			el = el.next;
			if(el == null)
				return false;
		}
		//   po potrebi posodobimo kazalec "last"
		//   vrnemo true
		// sicer
		//   vrnemo false
		if(el.next != null)
		{
			if(last == el.next)
				last = el;
			else if(last == el)
				last = prev;
			
			el.next = el.next.next;
			
			return true;
		}
		
		else
			return false;
	}
	
	//Funkcija reverse obrne vrstni red elementov v seznamu (pri tem ignorira glavo seznama)
	void reverse()
	{
		//ne pozabimo na posodobitev kazalca "last"!
		LinkedListElement cur;
		LinkedListElement tmp;
		//ce ni prazen in ima vsaj 2 elementa
		if(first.next != null && first.next.next != null)
		{
			cur = first.next.next;
			first.next.next = null;
			last = cur;
			
			while(cur != null)
			{
				tmp = cur.next;
				
				cur.next = first.next;
				first.next = cur;
				
				cur = tmp;
			}
			
		}
	}
	
	//Funkcija reverseRek klice rekurzivno funkcijo, ki obrne vrstni red elementov v seznamu
	void reverseRek()
	{
		// pomagajte si z dodatno funkcijo void reverseRek(LinkedListElement el), ki
		// obrne del seznama za opazovanim elementom, nato ta element doda na konec (obrnjenega) seznama
		reverseRek(first.next);
	}
	
	void reverseRek(LinkedListElement el)
	{
		//prazen seznam
		if(el == null)
			return;
		//samo en elemetn
		if(el.next == null)
		{
			first.next = el;
			last = first;
		}
		else
		{
			reverseRek(el.next);
			el.next = null;
			last = last.next;
			last.next = el;
		}
	}
	
	//Funkcija removeDuplicates odstrani ponavljajoce se elemente v seznamu
	void removeDuplicates()
	{
		//ne pozabimo na posodobitev kazalca "last"!
	}
}
