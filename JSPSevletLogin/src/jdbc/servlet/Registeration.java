package jdbc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registeration
 */
@WebServlet("/Registeration")
public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registeration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			String firstname= request.getParameter("fname");
			String lastname = request.getParameter("lname");
			String email = request.getParameter("email");
			String username = request.getParameter("uname");
			String password = request.getParameter("password");
			
			String sql = "INSERT INTO REGISTERATION (firstname, lastname, email, username, password) Values (?,?,?,?,?)";
			
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medhaniedb", "postgres", "thisshouldbeyourpassword");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, username);
			ps.setString(5, password);
			
			ps.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("You have successfully registered!");
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
