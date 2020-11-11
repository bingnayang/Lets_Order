package in.order.entity;

public class Ticket {
	private int ticket_Id;
	private int order_Id;
	private double orderTotal;
	private int orderQuantity;
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
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	@Override
	public String toString() {
		return "Ticket [orderTotal=" + orderTotal + ", orderQuantity=" + orderQuantity + "]";
	}
	
	
}
