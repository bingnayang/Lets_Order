package in.order.entity;

public class MenuInfo {
	private int item_Id;
	private String itemName;
	private double itemPrice;
	private String description;
	private String categoryType;
	
	
//	public MenuInfo(int item_Id, String itemName, double itemPrice, String description, String categoryType) {
//		this.item_Id = item_Id;
//		this.itemName = itemName;
//		this.itemPrice = itemPrice;
//		this.description = description;
//		this.categoryType = categoryType;
//	}
	public int getItem_Id() {
		return item_Id;
	}
	public void setItem_Id(int item_Id) {
		this.item_Id = item_Id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	
	
}
