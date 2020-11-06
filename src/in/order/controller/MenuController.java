package in.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	List<MenuInfo> bucketList = new ArrayList<MenuInfo>();;

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
			case "SELECT":
				getItem(request,response);	
				getMenuItem(request,response);
				break;
			case "DELETE_ALL":
				deleteAll(request,response);
				getMenuItem(request,response);
				break;
			case "DELETE":
				deleteAnItem(request,response);
//				getItem(request,response);
				getMenuItem(request,response);
				break;
		}
	}

	private void deleteAnItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Delete Item ID: "+id);
		
        Iterator<MenuInfo> itr = bucketList.iterator();
        while (itr.hasNext()) {
            MenuInfo number = itr.next();
            if (number.getItem_Id() == id) {
                itr.remove();
            }
        }
        request.setAttribute("bucketList",bucketList);
	}

	private void deleteAll(HttpServletRequest request, HttpServletResponse response) {
		bucketList.clear();

	}

	private void getItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		MenuInfo menuItem = menuDAO.getItem(id);
//		System.out.println("-------------------------");
//		System.out.println("Menu Id: "+menuItem.getItem_Id());
//		System.out.println("Menu Name: "+menuItem.getItemName());
//		System.out.println("Menu Price: "+menuItem.getItemPrice());
//		System.out.println("-------------------------");
		
		bucketList.add(menuItem);
		
		System.out.println("-------Bucket List--------");
		for(MenuInfo temp: bucketList) {
			System.out.println("ID: "+temp.getItem_Id()+" Name: "+temp.getItemName() +" Price: "+temp.getItemPrice());
		}

		
		request.setAttribute("bucketList",bucketList);
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
