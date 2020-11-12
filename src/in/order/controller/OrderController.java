package in.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.order.dao.OrderViewDAO;
import in.order.dao.OrderViewImpl;
import in.order.entity.OrderItem;
import in.order.entity.Ticket;

public class OrderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	OrderViewDAO orderViewDAO = null;
	
	public OrderController() {
		orderViewDAO = new OrderViewImpl();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderItemCountTemp = request.getParameter("item_Quantity");
		String orderTotalTemp = request.getParameter("order_Total");
		String[] itemNameArray = request.getParameterValues("item_Name");
		String[] itemPriceArray = request.getParameterValues("item_Price");
				
		Ticket ticket = new Ticket();
		ticket.setOrderQuantity(Integer.parseInt(orderItemCountTemp));
		ticket.setOrderTotal(Double.parseDouble(orderTotalTemp));
		

	    System.out.println("=================================");
		System.out.println("Order Item Quantity: "+ticket.getOrderQuantity());
		System.out.println("Order Total: $"+ticket.getOrderTotal());
		System.out.println("Order Item:");
		for(int i=0; i<itemNameArray.length; i++) {
			System.out.println(itemNameArray[i]+" | "+itemPriceArray[i]);
		}
	    System.out.println("=================================");

	    boolean submitOrder = orderViewDAO.submitOrder(ticket,itemNameArray,itemPriceArray);
		
		response.sendRedirect("MenuController?action=DELETE_ALL");
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "VIEW_ACTIVE":
			getActiveOrderList(request,response);
			break;
		}
	
	}
	private void getActiveOrderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Ticket> allActiveOrder = orderViewDAO.getActiveOrder();
		List<OrderItem> allOrderItem = orderViewDAO.getActiveOrderItem();

		request.setAttribute("allOrderItemList",allOrderItem);
		request.setAttribute("allOrderList",allActiveOrder);
		
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/order-view.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
		
	}
}
