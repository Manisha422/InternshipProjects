package web;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.bookDAO;
import model.book;

	@WebServlet("/")
	public class bookServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	    private bookDAO userDAO;

	    public void init() {
	        userDAO = new bookDAO();
	    }
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
	    	        doGet(request, response);
	    	    }

	    	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    	    throws ServletException, IOException {
	    	        String action = request.getServletPath();
	    	        try {
	    	            switch (action) {
	    	                case "/new":
	    	                    showNewForm(request, response);
	    	                    break;
	    	                case "/insert":
	    	                    insertUser(request, response);
	    	                    break;
	    	                case "/delete":
	    	                    deleteUser(request, response);
	    	                    break;
	    	                case "/edit":
	    	                    showEditForm(request, response);
	    	                    break;
	    	                case "/update":
	    	                    updateUser(request, response);
	    	                    break;
	    	                default:
	    	                    listUser(request, response);
	    	                    break;
	    	            }
	    	        } catch (SQLException ex) {
	    	            throw new ServletException(ex);
	    	        }
	    	    }

	    	    private void listUser(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
	    	        List < book > listUser = userDAO.selectAllBooks();
	    	        request.setAttribute("listUser", listUser);
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
	    	        dispatcher.forward(request, response);
	    	    }
	    	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	    	        	    throws ServletException, IOException {
	    	        	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	    	        	        dispatcher.forward(request, response);
	    	        	    }

	    	        	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    	        	    throws SQLException, ServletException, IOException {
	    	        	        int id = Integer.parseInt(request.getParameter("id"));
	    	        	        book existingUser = userDAO.selectBook(id);
	    	        	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
	    	        	        request.setAttribute("user", existingUser);
	    	        	        dispatcher.forward(request, response);

	    	        	    }
	    	        	    private void insertUser(HttpServletRequest request, HttpServletResponse response)
	    	        	    	    throws SQLException, IOException {
	    	        	    	        String name = request.getParameter("name");
	    	        	    	        int edition = Integer.parseInt(request.getParameter("edition"));
	    	        	    	        double price =Double.parseDouble(request.getParameter("price"));
	    	        	    	        book newUser = new book(name, edition, price);
	    	        	    	        userDAO.insertBooks(newUser);
	    	        	    	        response.sendRedirect("list");
	    	        	    	    }
	    	        	    private void updateUser(HttpServletRequest request, HttpServletResponse response)
	    	        	    	    throws SQLException, IOException {
	    	        	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        	    	        String name = request.getParameter("name");
	    	        	    	        int edition = Integer.parseInt(request.getParameter("edition"));
	    	        	    	        double price =Double.parseDouble(request.getParameter("price"));
	    	        	    	        book newBook = new book(id,name, edition, price);
	    	        	    	        
	    	        	    	        userDAO.updateBook(newBook);
	    	        	    	        response.sendRedirect("list");
	    	        	    	    }

	    	        	    	    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
	    	        	    	    throws SQLException, IOException {
	    	        	    	        int id = Integer.parseInt(request.getParameter("id"));
	    	        	    	        userDAO.deleteBook(id);
	    	        	    	        response.sendRedirect("list");

	    	        	    	    }
	    	        	    	}

