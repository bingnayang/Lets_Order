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


public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderViewDAO orderViewDAO = null;
	
	public OrderController() {
		orderViewDAO = new OrderViewImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderDetail> allActiveOrder = orderViewDAO.getActiveOrder();
		
		
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/order-view.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "POST":
			postOrder(request,response);
			break;
		}
	}

	private void postOrder(HttpServletRequest request, HttpServletResponse response) {
		
		
	}





}
