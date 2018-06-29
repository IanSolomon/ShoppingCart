package shoppingCart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart implements ICart{

	private int cartItemCount; //count of items in the cart
	private double sumTotal; // count of total cost of items
	private ArrayList<Item> itemsList; // list of all the items 
	private Map<String, Double > LookUpTable;
	private Map<String, Integer> CartItemsMultiplier;
	private String[][] itemsArray;//itemid and multiplier
	private int itemCount;
	public Cart(){
		this.itemsList = new ArrayList<Item>();
		this.sumTotal = 0;
		this.cartItemCount = this.itemsList.size();
		this.itemCount = 0;
	}
	
	@Override
	public void AddToCart(Item anItem) {
		//look in able then add the item based on cost
		//this.itemsList.add(anItem);
		if(CartItemsMultiplier.get(anItem.GetName()) != null)
		{
			if(CartItemsMultiplier.containsKey(anItem.GetName()))
			{
				CartItemsMultiplier.put(anItem.GetName(), CartItemsMultiplier.get(anItem.GetName()) + 1);
				++itemCount;
			}
			else{
				
				CartItemsMultiplier.put(anItem.GetName(), 1);
				++itemCount;		
			}
			
		}
		 CalculateCost(); //updates the cost as an item is added.
	}
	
	
	@Override
	public void PayForItems() {
		
		//pays for item the clears the list
		this.clearCart();
		
	}

	@Override
	public void CalculateCost() {
		double newTotal = 0;
		ArrayList<String> listofitems = new ArrayList<String>();
		listofitems.addAll(LookUpTable.keySet());
		
		/*for(int i =0; i < itemsList.size(); i++)
		{
			newTotal += itemsList.get(i).GetPrice();
		}*/
		for(int i = 0; i < listofitems.size(); i++ ){
			newTotal += (	CartItemsMultiplier.get(listofitems.get(i)) * LookUpTable.get(listofitems.get(i)).doubleValue());
			//LookUpTable.get(i).doubleValue();
		}
				
		this.sumTotal = newTotal;
	}


	@Override
	public void RemoveSelectedItem(Item anItem, int amountToRemove) {
		int count = amountToRemove;
		int itemID = anItem.GetID();
		
		for(int i = 0; i < itemsList.size(); i++){
			if(itemsList.get(i).GetID() == itemID  || count != 0)
			{
				itemsList.remove(i);
				--count;
			}
		}
		
		
	}


	@Override
	public void clearCart() {
		this.itemsList.clear();;
		
	}


	@Override
	public double GetTotalCost() {
		// TODO Auto-generated method stub
		return this.sumTotal;
	}

	@Override
	public int GetSizeOfItemList() {
		// TODO Auto-generated method stub
		return this.cartItemCount;
	}

	@Override
	public Item GetSelectedItem(int id) {
		//search then return an item 
		
		return null;
	}

	@Override
	public void InventoryList(Map<String, Double> ItemLookUp) {
		// TODO Auto-generated method stub
		this.LookUpTable = ItemLookUp; ;
		
	}
		
	
	
}
