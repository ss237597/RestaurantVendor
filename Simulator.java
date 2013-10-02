public class Simulator {
	public void add(LinkedList<FoodItem> fi, String text, double p, int q, String d, double s, String so, String c)	{
		fi.add(new FoodItem(text,p,q,d,s,so,c));
	}
	public void remove(LinkedList<FoodItem> fi, String text)	{
		try	{
			if (fi.containsName(text))	{
				if (fi.size() == 1)
					fi.list = null;
				else
					fi.oneBeforeContainingName(text).setLink(fi.oneBeforeContainingName(text).getLink().getLink());
				System.out.println("The product has been removed.");
			}
			else
				throw new NonexistentProductException();
		}
		catch(NonexistentProductException ex)	{
			System.out.println("The product does not exist in the list.");
		}

	}
	public void search(LinkedList<FoodItem> fi, String text)	{
		try	{
			if (!fi.containsName(text))
				throw new NonexistentProductException();
			else
				System.out.println("The product has been found.");
		}
		catch(NonexistentProductException ex)	{
			System.out.println("The product does not exist in the list.");
		}
	}
	public void update(LinkedList<FoodItem> fi, String text, double p, int q, String d, double s, String so, String c)	{
		try	{
			if (fi.containsName(text))
				fi.nodeContainingName(text).setElement(new FoodItem(text,p,q,d,s,so,c));
			else
				throw new NonexistentProductException();
		}
		catch(NonexistentProductException ex)	{
			System.out.println("The product does not exist in the list.");
		}
	}
	public void isEmpty(LinkedList<FoodItem> fi)	{
		if (fi.isEmpty())
			System.out.println("The list is empty.");
		else
			System.out.println("The list is not empty.");
	}
	public void print(LinkedList<FoodItem> fi, String s){
		LinkedListNode<FoodItem> temp = fi.list;
		while (!temp.getElement().name.equals(s))
			temp = temp.getLink();
		System.out.println(temp.getElement().toString());
	}
	public void print(LinkedList<FoodItem> fi)	{
		if (fi.isEmpty())
			System.out.println("The list is empty.");
		else
			System.out.println("Here is the list:" + fi.toString());
	}
	public class DuplicateProductException extends Exception	{
		public DuplicateProductException() {;}
	}
	public class NonexistentProductException extends Exception	{
		public NonexistentProductException() {;}
	}
}
