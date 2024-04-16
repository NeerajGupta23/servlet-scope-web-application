// Write a Program display hit count(no of request) of web-application

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

@WebServlet("/forall")
public class GlobalRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// for LoginedUsers class
		HttpSession session = request.getSession();
		session.setAttribute("flag", true);

		ServletContext context = getServletContext();
		Integer hitCount = (Integer) context.getAttribute("HitCount");

		if (hitCount != null) {
			hitCount++;
			context.setAttribute("HitCount", hitCount);
		} else {
			hitCount = 1;
			context.setAttribute("HitCount", hitCount);
		}

		PrintWriter out = response.getWriter();
		out.println("<h1 style='text-align: center'>Total Global Request : " + hitCount
				+ " (Reload Page for Functionality)</h1>");
		out.close();
	}
}
