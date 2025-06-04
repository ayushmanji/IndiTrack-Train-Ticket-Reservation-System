package com.indiTrack.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indiTrack.constant.ResponseCode;
import com.indiTrack.constant.UserRole;
import com.indiTrack.utility.TrainUtil;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String uName = req.getParameter("uname");
		String pWord = req.getParameter("pword");

		String responseMsg = TrainUtil.login(req, res, UserRole.CUSTOMER, uName, pWord);
		if (ResponseCode.SUCCESS.toString().equalsIgnoreCase(responseMsg)) {
			RequestDispatcher rd = req.getRequestDispatcher("UserHome.html");
			rd.include(req, res);
			pw.println("<div class='tab'>" +
				    "<p1 class='menu'>" +
				    "Hello " + TrainUtil.getCurrentUserName(req) + ", welcome to the IndiTrack Portal!" +
				    "</p1>" +
				"</div>");

				pw.println("<div class='tab'>" +
				    "Hi " + TrainUtil.getCurrentUserName(req) + "! We're glad to have you back.<br/>" +
				    "From here, you can access train information, schedules, fare enquiries, and much more.<br/>" +
				    "Use the navigation links on the left to explore all the features we offer.<br/><br/>" +
				    "<strong>Thank you for choosing IndiTrack. Happy traveling!</strong>" +
				"</div>");

		} else {
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.html");
			rd.include(req, res);

			pw.println("<div class='tab'><p1 class='menu'>" + responseMsg + "</p1></div>");

		}

	}

}
