package in.order.entity;

import java.util.Arrays;
import java.util.List;

public class OrderItem {
	private int order_Id;
	private String[] itemName;
	private String[] itemPrice;
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public String[] getItemName() {
		return itemName;
	}
	public void setItemName(String[] itemName) {
		this.itemName = itemName;
	}
	public String[] getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String[] itemPrice) {
		this.itemPrice = itemPrice;
	}
	@Override
	public String toString() {
		return "OrderItem [itemName=" + Arrays.toString(itemName) + ", itemPrice=" + Arrays.toString(itemPrice) + "]";
	}


 

}
