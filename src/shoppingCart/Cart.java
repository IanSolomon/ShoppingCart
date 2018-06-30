package shoppingCart;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart implements ICart{

	private int cartItemCount; //count of items in the cart
	private double sumTotal; // count of total cost of items
	private ArrayList<Item> itemsList; // list of all the items 
	/*private Map<String, Double > LookUpTable;
	private Map<String, Integer> CartItemsMultiplier;
	private String[][] itemsArray;//itemid and multiplier*/
	private ArrayList<Integer> itemAmounts;
	private int itemCount;
	public Cart(){
		itemAmounts = new ArrayList<Integer>();
		this.itemsList = new ArrayList<Item>();
		
		this.sumTotal = 0;
		this.cartItemCount = this.itemsList.size();
		this.itemCount = 0;
		
	}
	
	@Override
	public void AddToCart(Item anItem) {
		//look in able then add the item based on cost
		if(itemsList.size() > 0)
		{
			for(int i = 0; i < itemsList.size(); i++)
			{
				if(itemsList.get(i).GetID() == anItem.GetID() && itemsList.size() != 0 )
				{
					int addToAmount  = itemAmounts.get(i).intValue();
					itemAmounts.set(i, ++addToAmount);
					
				}
				else
				{
					this.itemsList.add(anItem);
					this.itemAmounts.add(1);
					
				}
	
			}
		}
			else
			{
				this.itemsList.add(anItem);
				this.itemAmounts.add(1);
				
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
		for(int i = 0; i < itemsList.size(); i++)
		{
			newTotal += (itemsList.get(i).GetPrice() * itemAmounts.get(i).intValue());
		}
					
			this.sumTotal = newTotal;
		}


	@Override
	public void RemoveSelectedItem(Item anItem, int amountToRemove) {
		int itemID = anItem.GetID();		
		for(int i = 0; i < itemsList.size(); i++){
			if(itemsList.get(i).GetID() == itemID )
			{
				int itemTotal = itemAmounts.get(i).intValue();
				
				itemTotal = itemTotal - amountToRemove;
				if(itemTotal < 0)
				{
					itemAmounts.set(i, 0);
				}else{
					itemAmounts.set(i, itemTotal);		
				}		
			}
		}
		
		
	}


	@Override
	public void clearCart() {
		this.itemsList.clear();
		this.itemAmounts.clear();
		
	}


	@Override
	public double GetTotalCost() {
		// TODO Auto-generated method stub
		return this.sumTotal;
	}

	@Override
	public int GetSizeOfItemList() {
		// TODO Auto-generated method stub
		this.cartItemCount = 0;
		for(int i = 0; i < this.itemsList.size(); i++)
		{
			this.cartItemCount = this.itemAmounts.get(i).intValue();
		}
	
		
		return this.cartItemCount;
	}

	@Override
	public Item GetSelectedItem(int id) {
		//search then return an item 
		
		return null;
	}

	/*@Override
	public void InventoryList(Map<String, Double> ItemLookUp) {
		// TODO Auto-generated method stub
		this.LookUpTable = ItemLookUp; ;
		
	} */
		
	
	
}
