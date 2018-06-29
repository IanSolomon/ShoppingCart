package shoppingCart;

public class Item {
	private int id;
	private double cost;
	private String name;
	public Item(String itemname, double itemcost, int id)
	{
		this.name = itemname;
		this.cost = itemcost;
		this.id = id;
	}

	public int GetID(){
		return this.id;
	}
	
	public String GetName(){
		return this.name;
	}
	
	public double GetPrice(){
		return this.cost;
	}
	
	
	
}
