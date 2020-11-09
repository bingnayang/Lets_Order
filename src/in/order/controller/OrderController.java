package in.order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	OrderView orderViewDAO = null;
	
	public OrderController() {
//		orderViewDAO = new OrderViewImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "VIEW":
			
			break;
		
		}
		
	}



}
