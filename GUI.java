import java.awt.event.*;
import javax.swing.*;

/**
 * @author Sam
 * Creates GUI
 */
public class GUI extends JPanel implements ActionListener {
	LinkedList<FoodItem> foodItemList = new LinkedList<FoodItem>();
	CategoryList<LinkedList<FoodItem>> categoryList = new CategoryList<LinkedList<FoodItem>>();
	protected JButton[] buttons = new JButton[7];
	String[] buttonNames = {"Submit", "Add Item", "Remove Item", "Search for Item", "Update Item", "Check if List is Empty", "Print Items"};
	String[] buttonCommands = {"submit", "add", "remove", "search", "update", "isEmpty", "print"};
	protected JTextField textField;
	public GUI() {
		textField = new JTextField(20);
		textField.addActionListener(this);
		add(textField);
		for (int i = 0; i < 7; i++)	{
			buttons[i] = new JButton(buttonNames[i]);
			buttons[i].setActionCommand(buttonCommands[i]);
			buttons[i].setVerticalTextPosition(AbstractButton.CENTER);
			buttons[i].setHorizontalTextPosition(AbstractButton.LEADING);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}
	boolean textSubmitted = false;
	String current_command = "";
	Simulator helper = new Simulator();
	String text = "";
	String name = "";
	double p = 0.0;
	int q = 0;
	String d = "";
	double s = 0.0;
	String so = "";
	String c = "";
	public void add()	{
		textSubmitted = false;
		current_command = "";
		if (!foodItemList.containsName(text))	{
			name = text;
			System.out.println("Please enter the price of the product.");
			current_command = "add1";
		}
	}
	public void add_p()	{
		textSubmitted = false;
		current_command = "";
		p = Double.parseDouble(text);
		System.out.println("Please enter the quantity of the product.");
		current_command = "add2";
	}
	public void add_q()	{
		textSubmitted = false;
		current_command = "";
		q = Integer.parseInt(text);
		System.out.println("Please enter the description of the product.");
		current_command = "add3";
	}
	public void add_d()	{
		textSubmitted = false;
		current_command = "";
		d = text;
		System.out.println("Please enter the size of the product.");
		current_command = "add4";
	}
	public void add_s()	{
		textSubmitted = false;
		current_command = "";
		s = Double.parseDouble(text);
		System.out.println("Please enter the special order of the product.");
		current_command = "add5";
	}
	public void add_so()	{
		textSubmitted = false;
		current_command = "";
		so = text;
		System.out.println("Please enter the category of the product.");
		current_command = "add6";
	}
	public void add_c()	{
		textSubmitted = false;
		current_command = "";
		c = text;
		FoodItem f = new FoodItem(name,p,q,d,s,so,c);
		foodItemList.add(f);
	}
	public void remove()	{
		textSubmitted = false;
		current_command = "";
		helper.remove(foodItemList, text);
	}
	public void search()	{
		textSubmitted = false;
		current_command = "";
		helper.search(foodItemList, text);
	}
	public void update()	{
		textSubmitted = false;
		current_command = "";
		if (foodItemList.containsName(text))	{
			name = text;
			System.out.println("Please enter the price of the product.");
			current_command = "update1";
		}
	}
	public void update_p()	{
		textSubmitted = false;
		current_command = "";
		p = Double.parseDouble(text);
		System.out.println("Please enter the quantity of the product.");
		current_command = "update2";
	}
	public void update_q()	{
		textSubmitted = false;
		current_command = "";
		q = Integer.parseInt(text);
		System.out.println("Please enter the description of the product.");
		current_command = "update3";
	}
	public void update_d()	{
		textSubmitted = false;
		current_command = "";
		d = text;
		System.out.println("Please enter the size of the product.");
		current_command = "update4";
	}
	public void update_s()	{
		textSubmitted = false;
		current_command = "";
		s = Double.parseDouble(text);
		System.out.println("Please enter the special order of the product.");
		current_command = "update5";
	}
	public void update_so()	{
		textSubmitted = false;
		current_command = "";
		so = text;
		System.out.println("Please enter the category of the product.");
		current_command = "update6";
	}
	public void update_c()	{
		textSubmitted = false;
		current_command = "";
		c = text;
		helper.update(foodItemList, name, p, q, d, s, so, c);
	}
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(buttonCommands[0]))	{
			text = textField.getText();
			textSubmitted = true;
			textField.setText("");
			if (current_command.equals(buttonCommands[1]))
				add();
			else if (current_command.equals(buttonCommands[2]))
				remove();
			else if (current_command.equals(buttonCommands[3]))
				search();
			else if (current_command.equals(buttonCommands[4]))
				update();
			else if (current_command.equals("add1"))
				add_p();
			else if (current_command.equals("add2"))
				add_q();
			else if (current_command.equals("add3"))
				add_d();
			else if (current_command.equals("add4"))
				add_s();
			else if (current_command.equals("add5"))
				add_so();
			else if (current_command.equals("add6"))
				add_c();
			else if (current_command.equals("update1"))
				update_p();
			else if (current_command.equals("update2"))
				update_q();
			else if (current_command.equals("update3"))
				update_d();
			else if (current_command.equals("update4"))
				update_s();
			else if (current_command.equals("update5"))
				update_so();
			else if (current_command.equals("update6"))
				update_c();
		}
		else if (command.equals(buttonCommands[1]))	{
			System.out.println("Please enter the name of the product you want to add.");
			current_command = "add";
		}
		else if (command.equals(buttonCommands[2]))	{
			System.out.println("Please enter the name of the product you want to remove.");
			current_command = "remove";
		}
		else if (command.equals(buttonCommands[3]))	{
			System.out.println("Please enter the name of the product you want to search for.");
			current_command = "search";
		}
		else if (command.equals(buttonCommands[4]))	{
			System.out.println("Please enter the name of the product you want to update.");
			current_command = "update";
		}
		else if (command.equals(buttonCommands[5]))
			helper.isEmpty(foodItemList);
		else
			helper.print(foodItemList);
	}
	public static void createAndShowGUI() {
		JFrame frame = new JFrame("Vendor Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI newContentPane = new GUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
}
