package com.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegForm")
public class Register extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out =resp.getWriter();
		String name = req.getParameter("name1");
		String email=req.getParameter("email1");
		String pwd = req.getParameter("pwd1");
		String gender =req.getParameter("gender1");
		String city = req.getParameter("city1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","root");
			String sql="insert into register values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2,email);
			ps.setString(3,pwd);
			ps.setString(4, gender);
			ps.setString(5,city);
			int count =ps.executeUpdate();
			if(count>0) {
				resp.setContentType("text/html");
				out.print("<h3 style='color:green'> User registered successfully.. </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
				
			}else {
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'> User not registered successfully.. </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
		}catch(Exception e) {
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'> Exception Occured : "+e.getMessage()+"</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
				
		
	}

}
