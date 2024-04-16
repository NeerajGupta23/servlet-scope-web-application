// Write a program to display  number of request in current session

package in.mywebsite.neeraj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// for LoginedUsers class
		HttpSession session = request.getSession();
		session.setAttribute("flag", true);

		Integer countInSession = (Integer) session.getAttribute("session");
		if (countInSession == null) {
			countInSession = 1;
		} else {
			countInSession++;
		}
		session.setAttribute("session", countInSession);

		PrintWriter out = response.getWriter();
		out.println("<h1 style='text-align:center'>Total request in Particular Session : " + countInSession
				+ "   (Reload Page for Functionality)</h1>");
		out.close();
	}
}
