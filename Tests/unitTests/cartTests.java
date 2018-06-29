package unitTests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import shoppingCart.Cart;
import shoppingCart.Item;


//Testing the implementation of the Cart
public class cartTests {

	@Test
	public void DefaultValuesTest() {
		
		Cart carttestinstance;
		double costExtected = 0;
		carttestinstance = new Cart();
		
		 assertEquals(0,  Double.compare(costExtected, carttestinstance.GetTotalCost()));
		 assertEquals(0, carttestinstance.GetSizeOfItemList());
	}
	

	@Test
	public void CostOfItem() {
		
		Cart carttestinstance;
		carttestinstance = new Cart();
		Map<String, Double>ItemToLookUp = new HashMap<String, Double>() ;
		
		ItemToLookUp.put("Bag", 7.99);
		
		carttestinstance.AddToCart(new Item("Bag", 7.99, 1));
		carttestinstance.CalculateCost();
		carttestinstance.InventoryList(ItemToLookUp);
		//carttestinstance.GetSelectedItem();
		 assertEquals("7.99", carttestinstance.GetTotalCost());
	}
	
	

}
