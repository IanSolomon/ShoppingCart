package shoppingCart;

import java.util.Map;

public interface ICart {

	void AddToCart(Item anItem);
	void PayForItems();
	void CalculateCost();
	void RemoveSelectedItem(Item anItem, int amountToRemove);
	void clearCart();
	double GetTotalCost();
	int GetSizeOfItemList();
	Item GetSelectedItem(int id);
//	void InventoryList(Map<String, Double> ItemLookUp);
	
}
