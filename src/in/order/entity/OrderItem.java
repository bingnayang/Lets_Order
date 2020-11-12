package in.order.entity;

public class OrderItem {
	private int ticket_Id;
	private String[] itemName;
	private String[] itemPrice;
	private String name;
	private double price;

	public int getTicket_Id() {
		return ticket_Id;
	}
	public void setTicket_Id(int ticket_Id) {
		this.ticket_Id = ticket_Id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
