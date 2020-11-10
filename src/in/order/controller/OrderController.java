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
import in.order.entity.OrderDetail;

public class OrderController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	OrderViewDAO orderViewDAO = null;
	
	public OrderController() {
		orderViewDAO = new OrderViewImpl();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemCount = request.getParameter("item_Quantity");
		String orderTotal = request.getParameter("order_Total");
		
		System.out.println("Get: itemCount = "+itemCount);
		System.out.println("Get: orderTotal = "+orderTotal);
		
		response.sendRedirect("MenuController");
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
		List<OrderDetail> allActiveOrder = orderViewDAO.getActiveOrder();
		
		System.out.println("Active Order List:");
		for(OrderDetail temp: allActiveOrder) {
			System.out.println(temp);
			System.out.println(temp);
		}
		request.setAttribute("allOrderList",allActiveOrder);
		
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/order-view.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
		
	}
}
