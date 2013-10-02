public class FoodItem {
	String name;
	double price;
	int quantity;
	String description;
	double size;
	String special_order;
	String category;
	public FoodItem(String n, double p, int q, String d, double s, String so, String c)	{
		name = n;
		price = p;
		quantity = q;
		description = d;
		size = s;
		special_order = so;
		category = c;
	}
	@Override
	public String toString()	{
		String out = "";
		out += "Name: " + name + "\n";
		out += "Price: " + price + "\n";
		out += "Quantity: " + quantity + "\n";
		out += "Description: " + description + "\n";
		out += "Size: " + size + "\n";
		out += "Special order: " + special_order + "\n";
		out += "Category: " + category + "\n";
		return out;
	}
}
