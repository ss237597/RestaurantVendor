public class LinkedList <T> implements LinkedListInterface <T> {
	public LinkedListNode <T> list;
	public String name;
	public int count=0;
	public LinkedList() {
		this.name = "Linked List";
		list = null;
	}
	public LinkedList(String name) {
		this.name = name;
		list = null;
	}
	@Override
	public void add(T element) {
		if (!contains(element))	{
			LinkedListNode <T> newNode = new LinkedListNode<T>(element, list);
			list = newNode;
			count++;
		}
		else
			System.out.println("Element is already included.");
	}
	@Override
	public T remove(T element) {
		if (contains(element))	{
			LinkedListNode<T> previous = list;
			if (list.getLink() != null)	{
				LinkedListNode<T> current = list.getLink();
				while (!current.getElement().equals(element))	{
					previous = current;
					current = current.getLink();
				}
				if (current.getLink() == null)
					previous.setLink(null);
				else
					previous.setLink(current.getLink());
			}
			else
				list = null;
			count--;
			return element;
		}
		else	{
			System.out.println("Element is not in the list.");
			return null;
		}
	}
	public T pop() {
		T temp = list.getElement();
		list = list.getLink();
		count--;
		return temp;
	}
	@Override
	public boolean contains(T element) {
		LinkedListNode<T> current = list;
		if (!isEmpty()) {
			while (current != null) {
				if (current.getElement().equals(element))
					return true;
				current = current.getLink();
			}
		}
		return false;
	}
	public boolean containsName(String s)	{
		LinkedListNode<T> current = list;
		if (isEmpty())
			return false;
		else	{
			while (current != null)	{
				if (current.getElement().getClass().getName().equals("FoodItem"))	{
					FoodItem fi = (FoodItem) current.getElement();
					if (fi.name.equals(s))
						return true;
				}
			current = current.getLink();
			}
			return false;
		}
	}
	public LinkedListNode<T> nodeContainingName(String s)	{
		LinkedListNode<T> current = list;
		while (current != null) {
			if (current.getElement().getClass().getName().equals("FoodItem"))	{
				FoodItem fi = (FoodItem) current.getElement();
				if (fi.name.equals(s))
					return current;
			}
			current = current.getLink();
		}
		return null;
	}
	public LinkedListNode<T> oneBeforeContainingName(String s)	{
		LinkedListNode<T> previous = list;
		if (previous.getLink() != null)	{
			LinkedListNode<T> current = previous.getLink();
			while (current != null) {
				if (current.getElement().getClass().getName().equals("FoodItem"))	{
					FoodItem fi = (FoodItem) current.getElement();
					if (fi.name.equals(s))
						return previous;
				}
				previous = current;
				current = current.getLink();
			}
		}
		return null;
	}
	@Override
	public boolean isEmpty() {
		if (list == null)
			return true;
		else
			return false;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int size() {
		return this.count;
	}
	@Override
	public String toString() {
		String out = "";
		LinkedListNode<T> temp;
		temp = list;
		while (temp != null) {
			if (temp.getElement() instanceof FoodItem)	{
				FoodItem fi = (FoodItem) temp.getElement();
				out += fi.toString();
			}
			temp = temp.getLink();
		}
		return out;
	}
}
