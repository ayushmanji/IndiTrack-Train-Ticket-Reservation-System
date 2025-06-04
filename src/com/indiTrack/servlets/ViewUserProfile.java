package com.indiTrack.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.indiTrack.beans.UserBean;
import com.indiTrack.constant.UserRole;
import com.indiTrack.utility.TrainUtil;

@SuppressWarnings("serial")
@WebServlet("/viewuserprofile")
public class ViewUserProfile extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		TrainUtil.validateUserAuthorization(req, UserRole.CUSTOMER);

		UserBean ub = TrainUtil.getCurrentCustomer(req);
		RequestDispatcher rd = req.getRequestDispatcher("UserHome.html");
		rd.include(req, res);
		pw.println("<div class='tab'>" + "		<p1 class='menu'>" + "	Hello " + TrainUtil.getCurrentUserName(req)
				+ " ! Welcome to our new NITRTC Website" + "		</p1>" + "	</div>");
		pw.println("<div class='main' style='display: flex; justify-content: center; gap: 1rem; flex-wrap: wrap;'>"
		        + "<a href='viewuserprofile' style='display: inline-block; background-color: #1d4ed8; color: white; padding: 10px 20px; border-radius: 6px; text-decoration: none; font-weight: 500;'>View Profile</a>"
		        + "<a href='edituserprofile' style='display: inline-block; background-color: #1d4ed8; color: white; padding: 10px 20px; border-radius: 6px; text-decoration: none; font-weight: 500;'>Edit Profile</a>"
		        + "<a href='changeuserpassword' style='display: inline-block; background-color: #1d4ed8; color: white; padding: 10px 20px; border-radius: 6px; text-decoration: none; font-weight: 500;'>Change Password</a>"
		    + "</div>");
		pw.println("<div class='tab'>Users Profile View</div>");
		pw.println("<div class='tab'>" + "<table>" + "<tr><td>Profile Photo :</td><td>Not Available</td></tr>"
				+ "<tr><td>User Name :</td><td>" + ub.getMailId() + "</td></tr>"
				+ "<tr><td>Password :</td><td><input type='password' disabled value='" + ub.getPWord() + "'/></td></tr>"
				+ "<tr><td>First Name :</td><td>" + ub.getFName() + "</td></tr>" + "<tr><td>Last Name :</td><td>"
				+ ub.getLName() + "</td></tr>" + "<tr><td>Address :</td><td>" + ub.getAddr() + "</td></tr>"
				+ "<tr><td>Phone No:</td><td>" + ub.getPhNo() + "</td></tr>" + "<tr><td>Mail Id :</td><td>"
				+ ub.getMailId() + "</td></tr>" + "</table>" + "</div>");

	}

}
