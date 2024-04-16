//Write a Program to display the number of users login to that application -> count newly created session

package in.mywebsite.neeraj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginedUsers")
public class LoginedUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		Integer count = (Integer) context.getAttribute("newSessions");

		Integer hitCount = (Integer) context.getAttribute("HitCount");
		HttpSession session = request.getSession();

		if (session.isNew()) {
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
		} else if ((Boolean) session.getAttribute("flag") == true) {
			if (count == null) {
				count = 1;
			} else {
				count++;
			}
			session.setAttribute("flag", false);
		}

		context.setAttribute("newSessions", count);
		PrintWriter out = response.getWriter();
		out.println("<h1 style='text-align:center'>Total Logined Users : " + count + "   (Reload Page for Functionality)</h1>");
		out.close();
	}
}
