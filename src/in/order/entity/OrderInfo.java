package in.order.entity;

public class OrderInfo {
	private int ticket_Id;
	private int order_Id;
	private String itemName;
	private double itemPrice;
	private int orderQuantity;
	private double orderTotal;
	
	public int getTicket_Id() {
		return ticket_Id;
	}
	public void setTicket_Id(int ticket_Id) {
		this.ticket_Id = ticket_Id;
	}
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
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
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}


	
}
