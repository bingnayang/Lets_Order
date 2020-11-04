package in.order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.order.dao.MenuDAO;
import in.order.dao.MenuDAOImplement;
import in.order.entity.MenuInfo;


public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Create a reference variable
	MenuDAO menuDAO = null;
	
	public MenuController() {
		menuDAO = new MenuDAOImplement();
	} 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			action = "LIST";
		}
		switch(action) {
			case "LIST":
				getMenuItem(request,response);
				break;

		}

	}

	public void getMenuItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MenuInfo> allMenuList = menuDAO.getMenu();		
	
		request.setAttribute("allMenuList",allMenuList);
		// Get the request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/order.jsp");
		// Forward the request and response objects
		dispatcher.forward(request,response);
	}
}
