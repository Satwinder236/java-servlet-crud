package com.cestar.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestar.dao.EmpDao;

import com.cestar.model.Employee;

/**
 * Servlet implementation class MyFirstServlet
 */

@WebServlet("/")
public final class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyFirstServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String url = request.getServletPath();
		
		switch(url) {
		
			case "/insert": {
//				out.print("<h1 style='color:red; text-align:center'>Welcome from insert page !!!</h1>");
				insertRecord(request, response);
				break;
			}
			
			case "/display": {
//				out.print("<h1 style='color:green; text-align:center'>Welcome from display page !!!</h1>");
				displayRecord(request, response);
				break;
			}
			
			case "/edit": {
//				out.print("<h1 style='color:orange; text-align:center'>Welcome from edit page !!!</h1>");
				editRecord(request,response);
				break;
			}
			
			case "/update": {
//				out.print("<h1 style='color:orange; text-align:center'>Welcome from edit page !!!</h1>");
				updateRecord(request,response);
				break;
			}
			
			case "/delete": {
//				out.print("<h1 style='color:gray; text-align:center'>Welcome from delete page !!!</h1>");
				deleteRecord(request, response);
				break;
			}
			
			
		}
		
//		int id = Integer.parseInt(request.getParameter("e_id"));
//		String name = request.getParameter("e_name");
//		String contact = request.getParameter("econtact");
//		String city = request.getParameter("ecity");
//		String email = request.getParameter("eemail");
//	
//		
//		
//		out.print("<body bgcolor='pink'>");
//		
//		out.print("<h1 style='color:red; text-align:center;'>Welcome from first servlet dear students</h1>");
//		
//		out.print("Employer Id : "+id+"<br>");
//		
//		out.print("Employee Name : "+name+"<br>");
//		out.print("Employee Contact No:"+contact+"<br>");
//		out.print("Employee city : "+city+"<br>");
//		out.print("Employee email : "+email+"<br>");
//		
//		EmpDao obj = new EmpDao();
//		
//		Employee emp_to_insert_in_db = new Employee(id, name, contact, city, email);
//		
//		int status = 0;
//		try {
//			
//			status = obj.insertRec(emp_to_insert_in_db);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		if(status > 0) {
//			out.print("<h1>Record inserted in the database</h1>");
//		}
//		else {
//			out.print("<h1>Some error occurred while adding employee!</h1>");
//		}
//		
//		out.print("</body>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void insertRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("e_id"));
		String name = request.getParameter("e_name");
		String contact = request.getParameter("econtact");
		String city = request.getParameter("ecity");
		String email = request.getParameter("eemail");
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.print("<body bgcolor='pink'>");
		
		out.print("<h1 style='color:red; text-align:center;'>Welcome from first servlet dear students</h1>");
		
		out.print("Employer Id : "+id+"<br>");
		
		out.print("Employee Name : "+name+"<br>");
		out.print("Employee Contact No:"+contact+"<br>");
		out.print("Employee city : "+city+"<br>");
		out.print("Employee email : "+email+"<br>");
		
		EmpDao obj = new EmpDao();
		
		Employee emp_to_insert_in_db = new Employee(id, name, contact, city, email);
		
		int status = 0;
		try {
			
			status = obj.insertRec(emp_to_insert_in_db);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(status > 0) {
			out.print("<h1>Record inserted in the database</h1>");
		}
		else {
			out.print("<h1>Some error occurred while adding employee!</h1>");
		}
		
		out.print("</body>");

	}
	
	protected void displayRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		EmpDao obj = new EmpDao();
		
		List<Employee> emps_from_db = obj.displayAllRecords();
		
//		out.print(emps_from_db);
		
		// create HttpSession Object and set the list as attribute
		
		HttpSession session = request.getSession();
		
		session.setAttribute("empz", emps_from_db);
		
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		
		rd.forward(request, response);
		
	}

	protected void editRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		int e_id = Integer.parseInt(request.getParameter("e_id"));
		
		EmpDao obj = new EmpDao();
		
		Employee emp_from_db = obj.getRecordByID(e_id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("emp", emp_from_db);
		
		session.setAttribute("old_id", e_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
		
		rd.forward(request, response);
		
		
	}
	
	protected void updateRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("e_id"));
		
		String name = request.getParameter("e_name");
		
		String contact = request.getParameter("econtact");
		
		String city = request.getParameter("ecity");
		
		String email = request.getParameter("eemail");
		
		Employee emp_updated = new Employee(id, name, contact, city, email);
		
		HttpSession session = request.getSession();
		
		int old_id = (int)session.getAttribute("old_id");
		
		EmpDao obj = new EmpDao();
		
		obj.updateRecord(emp_updated, old_id);
		
		displayRecord(request, response);
		
	}
	
	protected void deleteRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("e_id"));
		
		
		EmpDao obj = new EmpDao();
		
		obj.deleteRecord(id);
		
		displayRecord(request, response);
		
	}
}
