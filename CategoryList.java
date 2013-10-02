public class CategoryList <T> implements CategoryListInterface <T> {
	public CategoryNode <T> list;
	public String name;
	public int count=0;
	public CategoryList() {
		this.name = "Category List";
		list = null;
	}
	public CategoryList(String name) {
		this.name = name;
		list = null;
	}
	@Override
	public void add(T element) {
		if (!contains(element))	{
			CategoryNode <T> newNode = new CategoryNode<T>(element, list);
			list = newNode;
			count++;
		}
		else
			System.out.println("Element is already included.");
	}
	@Override
	public T remove(T element) {
		if (contains(element))	{
			CategoryNode<T> previous = list;
			if (list.getLink() != null)	{
				CategoryNode<T> current = list.getLink();
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
		CategoryNode<T> current = list;
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
		CategoryNode<T> current = list;
		if (!isEmpty()) {
			while (current != null) {
				if (current.getElement().getClass().getName().equals("FoodItem"))	{
					FoodItem fi = (FoodItem) current.getElement();
					if (fi.name.equals(s))
						return true;
				}
				current = current.getLink();
			}
		}
		return false;
	}
	public CategoryNode<T> nodeContainingName(String s)	{
		CategoryNode<T> current = list;
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
	public CategoryNode<T> oneBeforeContainingName(String s)	{
		CategoryNode<T> previous = list;
		if (previous.getLink() != null)	{
			CategoryNode<T> current = previous.getLink();
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
		CategoryNode<T> temp;
		temp = list;
		while (temp != null) {
			if (temp.getClass().getName().equals("FoodItem"))	{
				FoodItem fi = (FoodItem) temp.getElement();
				out += fi.toString();
			}
			temp = temp.getLink();
		}
		return out;
	}
}
