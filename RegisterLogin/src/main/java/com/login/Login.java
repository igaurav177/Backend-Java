package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Result;

@WebServlet("/LoginForm")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String email=req.getParameter("email1");
		String pwd = req.getParameter("pwd1");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","root");
			
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and pwd=?");
			ps.setString(1,email);
			ps.setString(2, pwd);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				HttpSession session = req.getSession();
				session.setAttribute("session_name", rs.getString("name"));
				RequestDispatcher rd =req.getRequestDispatcher("/profile.jsp");
				rd.include(req,resp);
			}else {
				
				out.print("<h3 style='color :red'> Email id and password didn't matched </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
			}
		}catch(Exception e) {
			e.printStackTrace();

			out.print("<h3 style='color :red'> "+e.getMessage()+" </h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}
	}

}
