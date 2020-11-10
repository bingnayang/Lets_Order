package in.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.order.dao.OrderViewDAO;
import in.order.dao.OrderViewImpl;
import in.order.entity.MenuInfo;
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
		
		List<String> itemName = new ArrayList<String>();
		
		String[] value = request.getParameterValues("item_Name");
        for(int i=0;i<value.length;i++) {
        	itemName.add(request.getParameterValues("item_Name")[i]);
        }

		
		System.out.println("Get: itemCount = "+itemCount);
		System.out.println("Get: orderTotal = "+orderTotal);
		System.out.println("Get: itemName = ");
		for(String temp: itemName) {
			System.out.println(temp);
		}
		
		
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
