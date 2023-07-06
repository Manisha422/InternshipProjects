package com.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * Servlet implementation class Register
 */
@WebServlet("/CourseReg")

public class CourseReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseReg() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cour="";
		String studentId=request.getParameter("sid");
		String studentName=request.getParameter("sname");
		String phoneNo=request.getParameter("phno");
		String email=request.getParameter("email");
		String branch=request.getParameter("branch");
		String currentYear=request.getParameter("currentYear");
		String gender=request.getParameter("gender");
		
		out.println(" Information is:</br>");
		out.println("First Name:"+studentName+"</br>");
		out.println("Phone Number:"+phoneNo+"</br>");
		out.println("Email:"+email+"</br>");
		out.println("Branch:"+branch+"</br>");
		out.println("Current Year:"+currentYear+"</br>");
		out.println("Gender:"+gender+"</br>");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/coursereg","root","root");
			PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			
			
			ps.setString(1, studentId);
			ps.setString(2, studentName);
			ps.setString(3, phoneNo);
			ps.setString(4, email);
			ps.setString(5, branch);
			ps.setString(6, currentYear);
			ps.setString(7, gender);
			int i=ps.executeUpdate();
			
			if(i>0){
				out.print("Data Inserted Successfully");
			}
			
			String[] val=request.getParameterValues("course");
		    String query2="insert into course values (?,?)";
		    PreparedStatement pt1=con.prepareStatement(query2);
		    for(int j=0;j<val.length;j++)
		    {
		    	pt1.setString(1,studentId);
		    	pt1.setString(2,val[j] );
		    	pt1.execute();
		    }

			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}

